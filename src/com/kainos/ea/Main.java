package com.kainos.ea;
import com.kainos.ea.employee.Employee;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        // write your code here

        //basic db conn code
        long t0, t1, t2;
        t0 = System.nanoTime();
        List<Employee> bigEmps = HRSystemDB.getAllEmployees();
        t1 = System.nanoTime();

        t2 = System.nanoTime();
        System.err.println(bigEmps.size() + " elements in the list.");
        System.err.println("Query took "
                + (t1-t0) + " nanos.");
        System.err.println("Streaming took "
                + (t2-t1) + " nanos.");
    }
}
