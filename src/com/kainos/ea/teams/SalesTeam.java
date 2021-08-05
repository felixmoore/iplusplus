package com.kainos.ea.teams;
import com.kainos.ea.HRSystemDB;
import com.kainos.ea.employee.SalesEmployee;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTeam {
    private ArrayList<SalesEmployee> allSalesEmployees;

    public void handleUserInput(){
        System.out.println("Welcome to the sales team!");

        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("back")){
            System.out.println("");
            System.out.println("Type the letter for the functionality you would like (a) " +
                    "Get Highest Sales Total. Or type 'back' to return to main menu");

            input = userInput.nextLine();
            System.out.println(input);

            if(input.equalsIgnoreCase("a")){
                this.getHighestSalesTotal();
            }
        }
    }

    public void getAllSalesEmployees(){
        HRSystemDB.getAllEmployees();
    }

    public void getHighestSalesTotal(){

    }

}
