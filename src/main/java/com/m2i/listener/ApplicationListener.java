package com.m2i.listener;

import java.util.HashMap;
import java.util.List;

import com.m2i.entity.Client;
import com.m2i.utils.Constants;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	public static String DB_CLIENTS = "dbClients";
	public static String DB_ACCOUNTS = "dbAccounts";
	public static String DB_TRANSACTIONS = "dbAccounts";

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("Base de données clients créee");
    	sce.getServletContext().setAttribute(Constants.DB_CLIENTS, new HashMap<Long, Client>());
    	System.out.println("Base de données comptes créee");
    	sce.getServletContext().setAttribute(Constants.DB_ACCOUNTS, new HashMap<Integer, List<Object>>());
    	System.out.println("Base de données transactions créee");
    	sce.getServletContext().setAttribute(Constants.DB_TRANSACTIONS, new HashMap<Integer, List<Object>>());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}