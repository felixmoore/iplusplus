package com.kainos.ea;

import com.kainos.ea.employee.Employee;
import com.kainos.ea.employee.SalesEmployee;
import com.kainos.ea.teams.HRTeam;
import com.kainos.ea.teams.SalesTeam;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.kainos.ea.teams.TalentTeam;

import java.io.FileInputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Sets up database connection using stored credentials (from HRSystemDB.properties)
 * <p>
 * From Jeremy's example
 */
public class HRSystemDB {
    private static Connection c;

    private static Connection getConnection() {
        String user;
        String password;
        String host;
        Connection c;
        try (var f = new FileInputStream("HRSystemDB.properties")) {
            Properties props = new Properties();
            props.load(f);
            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");
            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain user, " +
                                "password, and host properties.");
            c = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/HRSystem_iplusplus", user, password);
//            System.out.println(c);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function to retrieve list of all employees in database.
     *
     * @return List of all employees.
     */
    public static List<Employee> getAllEmployees() {
        if (c == null) {
            c = getConnection();
        }
        List<Employee> employees = new ArrayList<>();
        try {
            Statement s = c.createStatement();
            ResultSet rows = s.executeQuery(
                    "SELECT employee_id AS `ID`,first_name, last_name, nin, salary, department, email, phone_number FROM Employee;");
            while (rows.next()) {
                employees.add(new Employee(
                        rows.getInt("ID"),
                        rows.getString("first_name"),
                        rows.getString("last_name"),
                        rows.getString("nin"),
                        rows.getFloat("salary"),
                        rows.getString("department"),
                        rows.getString("email"),
                        rows.getString("phone_number")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * Function to retrieve list of all sales employees in database.
     *
     * @return List of all sales employees.
     */
    public static List<SalesEmployee> getAllSalesEmployees() {
        if (c == null) {
            c = getConnection();
        }
        List<SalesEmployee> salesEmployees = new ArrayList<>();
        try {
            Statement s = c.createStatement();
            ResultSet rows = s.executeQuery(
                    "SELECT Employee.employee_id,first_name, last_name, nin, salary, department, email, phone_number, total_sales_monthly, commission FROM Employee JOIN Sales WHERE Employee.employee_id=Sales.employee_id;");
            while (rows.next()) {
                salesEmployees.add(new SalesEmployee(
                        rows.getInt("employee_id"),
                        rows.getString("first_name"),
                        rows.getString("last_name"),
                        rows.getString("nin"),
                        rows.getFloat("salary"),
                        rows.getString("department"),
                        rows.getString("email"),
                        rows.getString("phone_number"),
                        rows.getFloat("commission"),
                        rows.getFloat("total_sales_monthly")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesEmployees;
    }

    public static void addNewEmployee(String type) {
        if (c == null) {

            c = getConnection();

        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("National Insurance: ");
        String nationalInsurance = scanner.nextLine();

        System.out.println("Salary: ");
        Float salary = Float.parseFloat(scanner.nextLine());

        System.out.println("Department: "); //TODO enum
        String department = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();

        try {

            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO Employee(employee_id,first_name, last_name, nin, salary, department, email, phone_number) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, nationalInsurance);
            statement.setFloat(5, salary);
            statement.setString(6, department);
            statement.setString(7, email);
            statement.setString(8, phoneNumber);

            statement.execute();


            if (type == "Sales") {
                try {

                    System.out.println("Commission rate: ");
                    Float commission = Float.parseFloat(scanner.nextLine());


                    statement = c.prepareStatement(
                            "INSERT INTO Sales(total_sales_monthly, employee_id,commission) VALUES(0, ?, ?)");

                    statement.setInt(1, id);
                    statement.setFloat(2, commission);


                    statement.execute();

                    System.out.println("Sales employee creation successful.");
                } catch (SQLException se) {
                    System.out.println(se.getMessage());

                }
            } else if (type == "Technical") {
                //TODO
            } else if (type == "Employee") {
                System.out.println("Employee creation successful.");
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());

        }


    }

    public static void addNewProject(ArrayList<Project> newProjectList) {
        if (c == null) {
            c = getConnection();
        }
        try {
            assert c != null;
            for(var project: newProjectList) {
                PreparedStatement statement = c.prepareStatement(
                        "INSERT INTO Projects (start_date, end_date, project_manager, description, name, customer_id, budget) VALUES(?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, project.getStartDate());
                statement.setString(2, project.getEndDate());
                statement.setString(3, project.getProject_manager());
                statement.setString(4, project.getDescription());
                statement.setString(5, project.getName());
                statement.setString(6, project.getCustomerId());
                statement.setShort(7, (short) project.getBudget());
                statement.execute();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Projects did not add");
        }

    }
    public static void main(String[] args) {
        System.out.println("Welcome to the employee management system! You can exit anytime by typing exit!");
        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("exit")){
            System.out.println("Please select a team 'Sales Team', 'Talent Team', 'HR Team' ");
            input = userInput.nextLine();
            System.out.println(input);

            if (input.equalsIgnoreCase("sales team")) {
                SalesTeam st = new SalesTeam();
                st.handleUserInput();
                
            } else if (input.equalsIgnoreCase("hr team")) {
                HRTeam hr = new HRTeam();
                hr.handleUserInput();
                
            }else if (input.equalsIgnoreCase("talent team")){
               TalentTeam tt = new TalentTeam();
                tt.handleUserInput();
            }
        }
    }

}
