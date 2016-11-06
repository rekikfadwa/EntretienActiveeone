package com.java.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Statement;

public class MysqlConnect {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ficheprojectdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password01";
    private static final String MAX_POOL = "250";
    
    private Statement statement = null;

    // init connection object
    private Connection connection;
    

	// init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
                System.out.println(" connection succeeded...");
            } catch (Exception e) {
                e.printStackTrace();
            }
          //if connection is successfully established, create statement
            if(connection != null) {
    	    try {
    	       setStatement(connection.createStatement());
    	    } catch (SQLException e) {
    	       System.out.println("Unable to create statement");
    	    }
    	    
    	}
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}