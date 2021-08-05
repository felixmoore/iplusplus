package com.kainos.ea.teams;

import com.kainos.ea.HRSystemDB;
import com.kainos.ea.employee.Employee;


import java.util.List;
import java.util.Scanner;

public class HRTeam {
    private List<Employee> allEmployees;

    public void handleUserInput(){
        System.out.println("Welcome to the HR team!");

        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("back")){
            System.out.println("");
            System.out.println("Type the letter for the functionality you would like (a) " +
                    "Generate department report. Or type 'back' to return to main menu");

            input = userInput.nextLine();
            System.out.println(input);

            if(input.equalsIgnoreCase("a")){
                this.generateDepartmentReport();
            }
        }
    }

    public void generateDepartmentReport(){
        allEmployees = HRSystemDB.getAllEmployees();


    }
}
