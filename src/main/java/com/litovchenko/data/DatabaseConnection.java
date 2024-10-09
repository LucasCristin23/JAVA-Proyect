package com.litovchenko.data;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    //Define the path where is the database that we are going to use (and add some parameters)
    private final static String URL = "jdbc:mysql://localhost:3306/login?useSSL=false&useTimeZone=true&serverTimezone=UTC&allowPublicKeyReference=true";
    private final static String USER = "root";

    //Enter the password of the user to access into the database MySQL
    private final static String PASSWORD = "here goes a password";

    static {
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setInitialSize(100);
        return ds;
    }

    public static Connection getDatabaseConnection() throws SQLException {
        Connection con = getDataSource().getConnection();
        return con;
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }

    public static void close(Statement st) throws SQLException{
        st.close();
    }

    public static void close(Connection cn) throws SQLException{
        cn.close();

    }

}