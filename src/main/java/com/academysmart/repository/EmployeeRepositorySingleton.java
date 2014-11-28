package com.academysmart.repository;

import com.academysmart.exception.IncorrectEmailException;
import com.academysmart.exception.ServletException;
import com.academysmart.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositorySingleton {
    private static EmployeeRepositorySingleton instance;
    private List<Employee> employees = new ArrayList<Employee>();
    private EmployeeRepositorySingleton (){
    }

	public static synchronized EmployeeRepositorySingleton getRepository() {
		//TODO implement method that returns repository instance
        if(instance == null){
           instance = new EmployeeRepositorySingleton();
        }
		return instance;
	}

	public int addEmployee(String fname, String lname, String email)
            throws ServletException {
		//TODO implement method that adds an employee to repository
		//This method should check that email is not used by other employees
        if (fname.equals("") || lname.equals("") || email.equals("")){
            throw new ServletException("Вы не заполнили все поля");
        }
        int count = 0;
        if (!employees.isEmpty()) {
            for (Employee empl : employees) {
                if (empl.getEmail().equals(email)) {
                    throw new IncorrectEmailException("Такой email существует");
                }
                if (empl.getIdPerson() > count) {
                    count = empl.getIdPerson();
                }
                count++;
            }
        }
        Employee employee = new Employee();
        employee.setIdPerson(count);
        employee.setName(lname);
        employee.setFamily(fname);
        employee.setEmail(email);
        employees.add(employee);
		return count;
	}

	public List<Employee> getAllEmployees() {
		//TODO implement method that returns list of all employees
		return employees;
	}
}
