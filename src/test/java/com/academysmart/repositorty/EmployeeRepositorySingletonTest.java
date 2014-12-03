package com.academysmart.repositorty;

import com.academysmart.exception.IncorrectEmailException;
import com.academysmart.exception.ServletException;
import com.academysmart.repository.EmployeeRepositorySingleton;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class EmployeeRepositorySingletonTest {
    public static EmployeeRepositorySingleton ersTest1;
    public static EmployeeRepositorySingleton ersTest2;

    @BeforeClass
	public static void beforeClass()throws Exception {
       ersTest1 = EmployeeRepositorySingleton.getRepository();
       ersTest1.addEmployee("Олег","Иванов", "ivanov@mail.ru");
       ersTest2 = EmployeeRepositorySingleton.getRepository();
       //EmployeeRepositorySingleton.getRepository().addEmployee("Олег","Иванов", "ivanov@mail.ru");
	}

	@Test
	public void testGetRepositoryReturnOneInstance() {
        EmployeeRepositorySingleton ersTest2 = EmployeeRepositorySingleton.getRepository();
        Assert.assertEquals("Test is not implemented",ersTest1,ersTest2);
        //Assert.fail("Test is not implemented");
	}
	
	
	@Test(expected=IncorrectEmailException.class)
	public void testAddEmployeWithIncorrectEmail() throws ServletException, SQLException {
        EmployeeRepositorySingleton.getRepository().addEmployee("Ваня","Иванов", "ivanov@mail.ru");
		Assert.fail("Test is not implemented");
////       Assert.fail(String.valueOf(EmployeeRepositorySingleton.getRepository().addEmployee("Ваня","Иванов", "ivanov@mail.ru")));
	}

}
