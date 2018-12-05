package ch.makery.address.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MysqlConnect {
    private Connection connection;
    private Properties properties;
    private static final String URL = "jdbc:mysql://localhost:3306/kur?autoReconnect=true&useSSL=false";
    private static final String URLDB = "jdbc:mysql://localhost:3306/";
    private static final String URLTable = "jdbc:mysql://localhost:3306/kur";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kreatoris";
    private static final String MAX_POOL = "250";
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

    //String query = "select  * from mainwin";

    public MysqlConnect() {
    }

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
                connection = DriverManager.getConnection(URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
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

    public void IfNotCreate () throws SQLException {

        Connection conDB = DriverManager.getConnection(URLDB,USERNAME,PASSWORD);

        Statement s1 = conDB.createStatement();
        String s = "CREATE DATABASE IF NOT EXISTS `kur`";
        s1.executeUpdate(s);


        Connection conTable = DriverManager.getConnection(URLTable,USERNAME,PASSWORD);
        Statement s2 = conTable.createStatement();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS `mainwin` "
                + "  (id           INTEGER,"
                + "   date            VARCHAR(50),"
                + "   name          VARCHAR(45),"
                + "   firma           VARCHAR(50),"
                + "   content           VARCHAR(50),"
                + "   file     VARCHAR(100))";


        s2.execute(sqlCreate);
    }

}

