package com.kainos.ea.employee;

public class SalesEmployee extends Employee implements Comparable<SalesEmployee> {
    protected float commissionRate;
    protected float salesTotal;

    public SalesEmployee(int employee_id, String firstName, String lastName,
                         String nationalInsurance, float salary, String department,
                         String email, String phoneNumber, float commissionRate, float salesTotal) {

        super(employee_id, firstName, lastName, nationalInsurance, salary, department, email, phoneNumber);

        this.commissionRate = commissionRate;
        this.salesTotal = salesTotal;

    }

    public float getSalesTotal() {
        return salesTotal;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setSalesTotal(float salesTotal) {
        this.salesTotal = salesTotal;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public float calcPay() {
        return super.calcPay() + Math.round(commissionRate * salesTotal);
    }

    @Override
    public String toString() {
        return "SalesEmployee - " +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalInsurance='" + nationalInsurance + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", commissionRate=" + commissionRate +
                ", salesTotal=" + salesTotal ;
    }


    @Override
    public int compareTo(SalesEmployee salesEmployee) {
        return Float.compare(this.getSalesTotal(), salesEmployee.getSalesTotal());
    }

    public String highestSalestoString(){
        return "Highest Sale employee: " + "employee_id=" + getEmployee_id() +
                ", " + firstName + " " + lastName + " with " +
                salesTotal + " sales in total";
    }
}
 