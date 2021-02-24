package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeesCounterTest {

    Employee emp01 = new Employee("Ivan", 10000);
    Employee emp02 = new Employee("Vassily", 30000);
    Employee emp03 = new Employee("Tatiana", 40000);
    Employee emp04 = new Employee("Evgeniy", 20000);
    Employee emp05 = new Employee("Stepan", 50000);
    Employee emp06 = new Employee("Anna", 15000);
    Employee emp07 = new Employee("Olga", 12000);
    Employee emp08 = new Employee("Marina", 18000);
    Employee emp09 = new Employee("Sergey", 16000);
    Employee emp10 = new Employee("Pavel", 14000);


    Department dpt1 = new Department("Department 01", "0XXOTDEL", Arrays.asList(emp01, emp03, emp05, emp06));
    Department dpt2 = new Department("Department 02", "0XIOTDEL", Arrays.asList(emp02, emp04, emp08));
    Department dpt3 = new Department("Department 03", "0XXOTDEL", Arrays.asList(emp07, emp09, emp10));

    @Test
    public void getEmployeesQty_OXXPrefix_20000SalaryLimit(){
        EmployeesCounter counter = new EmployeesCounter(Arrays.asList(dpt1, dpt2, dpt3), 20000, "0XX");
        Assert.assertEquals(2, counter.getEmployeesQty());
    }

    @Test
    public void getEmployeesQty_OXXPrefix_40000SalaryLimit(){
        EmployeesCounter counter = new EmployeesCounter(Arrays.asList(dpt1, dpt2, dpt3), 20000, "0XX");
        Assert.assertEquals(2, counter.getEmployeesQty());
    }

    @Test
    public void getEmployeesQty_OXIPrefix_18000SalaryLimit(){
        EmployeesCounter counter = new EmployeesCounter(Arrays.asList(dpt1, dpt2, dpt3), 18000, "0XI");
        Assert.assertEquals(3, counter.getEmployeesQty());
    }

    @Test
    public void getEmployeesQty_OXIPrefix_25000SalaryLimit(){
        EmployeesCounter counter = new EmployeesCounter(Arrays.asList(dpt1, dpt2, dpt3), 25000, "0XI");
        Assert.assertEquals(1, counter.getEmployeesQty());
    }
}
