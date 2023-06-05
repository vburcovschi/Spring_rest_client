package org.example.spring.rest;

import org.example.spring.rest.configuration.MyConfig;
import org.example.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmployee = communication.getAllEmployees();
        System.out.println(allEmployee);
        Employee employee = communication.getEmployee(16);
        System.out.println(employee);
/*
        Employee employee1 = new Employee("Svetlana","Treban", "HR", 500);
        communication.saveEmployee(employee1);
*/
        Employee employee2 = communication.getEmployee(24);
        employee2.setDepartment("IT");
        employee2.setSalary(5000);
        communication.saveEmployee(employee2);
        communication.deleteEmployee(24);
    }
}
