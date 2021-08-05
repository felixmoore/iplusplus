package com.kainos.ea.employee;

public class Employee {
    protected int employee_id;
    protected String firstName;
    protected String lastName;
    protected String nationalInsurance;
    protected float salary;
    protected String department;
    protected String email;
    protected String phoneNumber;

    public Employee(int employee_id, String firstName,
                    String lastName, String nationalInsurance,
                    float salary, String department,
                    String email, String phoneNumber) {
        this.employee_id = employee_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalInsurance = nationalInsurance;
        this.salary = salary;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalInsurance() {
        return nationalInsurance;
    }

    public float getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalInsurance(String nationalInsurance) {
        this.nationalInsurance = nationalInsurance;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float calcPay(){
        return (float) ((salary/12)*0.75);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalInsurance='" + nationalInsurance + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
