package com.kainos.ea;

import com.kainos.ea.employee.Employee;
import com.kainos.ea.teams.SalesTeam;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Sets up database connection using stored credentials (from HRSystemDB.properties)
 *
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
            System.out.println(c);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Employee> getAllEmployees(){ //generic get method, to be adapted once database populated
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

    public static void main(String[] args) {
        System.out.println("Welcome to the employee management system? You can exit anytime by typing exit!");
        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("exit")){
            System.out.println("Please select a team 'Sales Team', 'HR Team");
            input = userInput.nextLine();
            System.out.println(input);

            if(input.equalsIgnoreCase("sales team")){
                SalesTeam st = new SalesTeam();
                st.handleUserInput();
            }
        }
    }

}
