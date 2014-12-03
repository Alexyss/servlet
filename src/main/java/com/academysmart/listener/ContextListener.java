package com.academysmart.listener;

import com.academysmart.repository.EmployeeRepositorySingleton;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
        //try {
            sce.getServletContext().setAttribute("employees", EmployeeRepositorySingleton.getRepository().getAllEmployees());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }
	
}
