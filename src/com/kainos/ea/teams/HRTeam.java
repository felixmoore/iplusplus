package com.kainos.ea.teams;

import com.kainos.ea.HRSystemDB;
import com.kainos.ea.employee.Employee;
import com.kainos.ea.employee.SalesEmployee;


import java.util.*;
import java.util.stream.Collectors;

public class HRTeam {
    private List<Employee> allEmployees;

    public void handleUserInput(){
        System.out.println("Welcome to the HR team!");

        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("back")){
            System.out.println("");
            System.out.println("Type the letter for the functionality you would like \n(a) " +
                    "Generate department report. \n" +
                    "(b) Add a new employee. \n Or type 'back' to return to main menu");

            input = userInput.nextLine();
            System.out.println(input);

            if(input.equalsIgnoreCase("a")){
                this.generateDepartmentReport();
            } if (input.equalsIgnoreCase("b")){
                System.out.println("");
                System.out.println("What kind of employee would you like to add? \n" +
                        "(a) Employee \n" +
                        "(b) Sales Employee. \n Or type 'back' to return to main menu");
                input = userInput.nextLine();
                if (input.equalsIgnoreCase("a")){
                    addNewEmployee();
                } else if (input.equalsIgnoreCase("b")){
                    addNewSalesEmployee();
                }
            }
        }
    }

    public void generateDepartmentReport(){ // Use case 2
        allEmployees = HRSystemDB.getAllEmployees();
        Map<String, List<Employee>> streamedList = allEmployees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        for (String key : streamedList.keySet()) {
            System.out.println("");
            System.out.println(streamedList.get(key).get(0).getDepartment()); //Print department
            for (int i=0; i<streamedList.get(key).size(); i++) {
                System.out.println(streamedList.get(key).get(i).getFirstName() + " " + streamedList.get(key).get(i).getLastName());
            }

        }

    }

    public void addNewEmployee(){
        System.out.println("");
        System.out.println("Adding new Employee:");
        HRSystemDB.addNewEmployee("Employee");
    }

    public void addNewSalesEmployee(){
        System.out.println("");
        System.out.println("Adding new Sales Employee:");
        HRSystemDB.addNewEmployee("Sales");
    }
}
