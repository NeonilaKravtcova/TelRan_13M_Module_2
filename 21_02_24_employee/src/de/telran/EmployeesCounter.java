package de.telran;

import java.util.List;


public class EmployeesCounter {

    private final List<Department> departments;
    private final long limit;
    private final String prefix;

    public EmployeesCounter(List<Department> departments, long limit, String prefix) {
        this.departments = departments;
        this.limit = limit;
        this.prefix = prefix;
    }

    public int getEmployeesQty(){
        return (int) departments
                .stream()
                .filter(department -> department.getCode().startsWith(prefix))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= limit)
                .count();
    }
}
