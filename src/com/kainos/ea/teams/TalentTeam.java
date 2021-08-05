package com.kainos.ea.teams;

import com.kainos.ea.HRSystemDB;
import com.kainos.ea.Project;
import java.util.ArrayList;
import java.util.Scanner;

public class TalentTeam {

    public void handleUserInput(){
        System.out.println("Welcome to the talent team!");

        Scanner userInput = new Scanner(System.in);
        String input = "";

        while(!input.equalsIgnoreCase("back")){
            System.out.println("Type the letter for the functionality you would like (a) " +
                    "Add new project. Or type 'back' to return to main menu");

            input = userInput.nextLine();

            if(input.equalsIgnoreCase("a")){
                this.createNewProject();
            }
        }
    }

    public void createNewProject(){
        Scanner userInput = new Scanner(System.in);
        String input = "";
        ArrayList<Project> newProjects = new ArrayList<>();

        while(!input.equalsIgnoreCase("no")){
            Project p1 = new Project();
            System.out.println("Please enter the name of a new project");
                input = userInput.nextLine();
                p1.setName(input);

            System.out.println("Please enter the description");
            input = userInput.nextLine();
            p1.setDescription(input);

            System.out.println("Please enter the start date");
            input = userInput.nextLine();
            p1.setStartDate(input);

            System.out.println("Please enter the end date");
            input = userInput.nextLine();
            p1.setEndDate(input);

            System.out.println("Please enter the project manager name");
            input = userInput.nextLine();
            p1.setProject_manager(input);

            System.out.println("Please enter the project customer id");
            input = userInput.nextLine();
            p1.setCustomerId(input);

            System.out.println("Please enter the budget of the project (No £ sign)");
            input = userInput.nextLine();
            p1.setBudget(input);
            newProjects.add(p1);

            System.out.println(p1);

            System.out.println("Would you like to add more projects? (Yes or No)");
            input = userInput.nextLine();

        }

        HRSystemDB.addNewProject(newProjects);


    }
}
