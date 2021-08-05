package com.kainos.ea;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Project {
    private int projectId;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int budget;
    private String project_manager;
    private String customerId;

    public Project(int projectId, String name, String description, Date startDate, Date endDate, int budget, String project_manager, String customerId) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.project_manager = project_manager;
        this.customerId = customerId;
    }

    public Project() {

    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(startDate);
    }

    public void setStartDate(String startDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            this.startDate = format.parse(startDate);
        } catch(ParseException e) {
            System.out.println("Incorrect date format please try format yyyy-MM-dd ");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();
            setStartDate(input);
        }
    }

    public String getEndDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(endDate);
    }

    public void setEndDate(String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            this.endDate = format.parse(endDate);

        } catch(ParseException e) {
            System.out.println("Incorrect date format please try format yyyy-MM-dd ");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();
            setEndDate(input);
        }
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        try {
            this.budget = Integer.parseInt(budget);
        } catch(Exception e){
            System.out.println("Incorrect format please try again ");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();
            setBudget(input);
        }
    }

    public String getProject_manager() {
        return project_manager;
    }

    public void setProject_manager(String project_manager) {
        this.project_manager = project_manager;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Project = " +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", budget=" + budget +
                ", project_manager='" + project_manager + '\'' +
                '}';
    }
}
