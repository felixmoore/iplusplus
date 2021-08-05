package com.kainos.ea.teams;

import com.kainos.ea.HRSystemDB;
import com.kainos.ea.employee.Employee;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FinanceTeam {
    private List<Employee> allEmployees;

    public void handleUserInput(){
        System.out.println("Welcome to the Finance team!");

        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("back")){
            System.out.println("");
            System.out.println("Type the letter for the functionality you would like \n(a) " +
                    "Generate gross pay report. \n" +
                    " Or type 'back' to return to main menu");

            input = userInput.nextLine();
            System.out.println(input);

            if(input.equalsIgnoreCase("a")){
                this.generateGrossPayReport();

            }
        }
    }

    public void generateGrossPayReport() {
        allEmployees = HRSystemDB.getAllEmployees();
        System.out.println("");
        System.out.println("Gross pay: ");

        for (int i = 0; i < allEmployees.size(); i++) {
            System.out.println(allEmployees.get(i).getFirstName() + " " + allEmployees.get(i).getLastName() + ", " + allEmployees.get(i).calcPay());
        }
    }
}


