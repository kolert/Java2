package lv.javaguru.java2.database;

import lv.javaguru.java2.config.ConfigParser;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class JDBCDatabase {

    protected String jdbcUrl;
    protected String driverClass;
    protected String userName;
    protected String password;


    public JDBCDatabase() {
        initDatabaseConnectionProperties();
        registerJDBCDriver();
    }

    private void registerJDBCDriver() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void initDatabaseConnectionProperties() {
        Properties properties = ConfigParser.getProperties();
        jdbcUrl = properties.getProperty("jdbc.url");
        driverClass = properties.getProperty("jdbc.driverClass");
        userName = properties.getProperty("jdbc.userName");
        password = properties.getProperty("jdbc.password");
    }

    protected Connection getConnection() {
        try{
            return DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            if(connection != null) {
                connection.close();
              }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
