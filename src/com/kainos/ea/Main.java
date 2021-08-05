package com.kainos.ea;
import com.kainos.ea.employee.Employee;
import com.kainos.ea.employee.SalesEmployee;

import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //basic db conn code
        long t0, t1, t2;
        t0 = System.nanoTime();
        List<Employee> bigEmps = HRSystemDB.getAllEmployees();
        List<SalesEmployee> sales = HRSystemDB.getAllSalesEmployees();
        t1 = System.nanoTime();
        OptionalDouble avgSalaries = bigEmps.stream()
//                .filter(e->e.getName().charAt(1) < 'M')
                .mapToDouble(emp->emp.getSalary())
                .sorted()
                .average();
        System.out.println(String.format("Average salary is £%,.2f.",
                avgSalaries.getAsDouble()));
        t2 = System.nanoTime();
        System.err.println(bigEmps.size() + " elements in the list.");
        System.err.println("Query took "
                + (t1-t0) + " nanos.");
        System.err.println("Streaming took "
                + (t2-t1) + " nanos.");

        System.err.println(sales);
        System.err.println(sales.size());
        System.err.println(sales.get(0));
    }
}
