package lv.javaguru.java2.database;

import lv.javaguru.java2.config.ConfigParser;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class JDBCDatabase {

    private static final String DB_CONFIG_FILE = "database.properties";

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
        ConfigParser parser = new ConfigParser();
        Properties properties = parser.loadProperties();

        jdbcUrl = properties.getProperty("url");
        driverClass = properties.getProperty("driverClass");
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");


//        jdbcUrl = "jdbc:mysql://localhost:3306/java2";
//        driverClass = "com.mysql.jdbc.Driver";
//        userName = "SYSDBA";
//        password = "masterkey";
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
