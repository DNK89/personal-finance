package lv.dnk89.personalfinance.database.jdbc;

import lv.dnk89.personalfinance.database.DBException;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DAOImpl {

    private static final String DB_CONFIG_FILE = "database.properties";

    private String jdbcUrl = null;
    private String driverClass = null;
    private String userName = null;
    private String password = null;


    public DAOImpl() {
        initDatabaseConnectionProperties();
        registerJDBCDriver();
    }

    private void registerJDBCDriver() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
        }
    }

    private void initDatabaseConnectionProperties() {
        Properties properties = new Properties();
        try {
            properties.load(DAOImpl.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE));

            jdbcUrl = properties.getProperty("jdbcUrl");
            driverClass = properties.getProperty("driverClass");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e){
            System.out.println("Exception while reading JDBC configuration from file = " + DB_CONFIG_FILE);
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws DBException {
        try{
            return DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    protected void closeConnectionResources(Connection connection, Statement statement, ResultSet rs) throws DBException {
        try {
            if(rs != null) {
                rs.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }
}
