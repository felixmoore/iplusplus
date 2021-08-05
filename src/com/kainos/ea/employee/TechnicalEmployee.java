package com.kainos.ea.employee;

public class TechnicalEmployee extends Employee {
    private String projectID;
    private boolean isProjectManger;

    public TechnicalEmployee(int employee_id, String firstName, String lastName,
                             String nationalInsurance, float salary, String department,
                             String email, String phoneNumber, String projectID, boolean isProjectManger) {

        super(employee_id, firstName, lastName, nationalInsurance, salary, department, email, phoneNumber);
        this.projectID = projectID;

        if (projectID != null) {
            this.isProjectManger = false;
        } else {
            this.isProjectManger = isProjectManger;
        }


    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public boolean isProjectManger() {
        return isProjectManger;
    }

    public void setProjectManger(boolean isProjectManger) {
        if(this.projectID != null && isProjectManger) {
            this.isProjectManger = false;
        }else{
            this.isProjectManger = isProjectManger;
        }
    }


}
