package com.litovchenko.data;

import static com.litovchenko.data.DatabaseConnection.getDatabaseConnection;
import static com.litovchenko.data.DatabaseConnection.close;
import com.litovchenko.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //Management of the database with Query
    private static final String SQL_SELECT = "SELECT * FROM users";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO users (username, password, email, name) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE users SET username = ?, password = ?, email = ?, name = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM users WHERE id = ?";


    //With this, we can show the list of users
    public static List<User> select(){
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> usersList = new ArrayList<>();

        try{
            cn = getDatabaseConnection();
            ps = cn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            //Iteration of the returns from the db into the ResultSet
            //Then I get the attributes of every single user and set it into the object user
            //Finally I save each user in the ArrayList
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("name");

                User user = new User(username, password, email, name);
                usersList.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace(System.out);
        } finally {
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (Exception e){
                e.printStackTrace(System.out);
            }
        }
        return usersList;
    }

    //Class to insert a new user into the database
    public static int insert (User user){
        Connection cn = null;
        PreparedStatement ps = null;
        int registers = 0;
        try {
            cn = getDatabaseConnection();
            ps = cn.prepareStatement(SQL_INSERT);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getName());

            registers = ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace(System.out);
        } finally {
            try{
                close(ps);
                close(cn);
            } catch (Exception e){
                e.printStackTrace(System.out);
            }
        }
        return registers;
    }

}
