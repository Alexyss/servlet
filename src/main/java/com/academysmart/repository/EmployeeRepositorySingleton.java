package com.academysmart.repository;

import com.academysmart.dbase.Dbase;
import com.academysmart.exception.IncorrectEmailException;
import com.academysmart.exception.ServletException;
import com.academysmart.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositorySingleton {
    private static EmployeeRepositorySingleton instance;
    private List<Employee> employees = new ArrayList<>();
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
            for (Employee empl : getAllEmployees()) {
                if (empl.getEmail().equals(email)) {
                    throw new IncorrectEmailException("Такой email существует");
                }
            }
        Dbase.execInsert("Insert into EMPLOYEES (NAME,FAMILY,EMAIL)values('" +
                lname + "','" +
                fname + "','" +
                email + "')");
		return 1;
	}

	public List<Employee> getAllEmployees()  {
		//TODO implement method that returns list of all employees
        employees = Dbase.execQueryEmployees("select IDPERSON, NAME, FAMILY, EMAIL from EMPLOYEES order by name");
        return employees;
	}
}










//
//int count = 0;
//if (!employees.isEmpty()) {
//        for (Employee empl : employees) {
//        if (empl.getEmail().equals(email)) {
//        throw new IncorrectEmailException("Такой email существует");
//        }
//        if (empl.getIdPerson() > count) {
//        count = empl.getIdPerson();
//        }
//        count++;
//        }
//        }