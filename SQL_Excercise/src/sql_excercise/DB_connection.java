package sql_excercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DB_connection {

    private static Connection Myconnection;

    public static void init() {
        try {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {

                System.out.println("Class not found");
            }
            Myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "rootroot");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public static Connection getConnection() {
        if (Myconnection != null) {
            return Myconnection;
        } else {
            try {

                Myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "rootroot");

            } catch (Exception ex) {

            }
        }
        return Myconnection;

    }

    public static void close(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}
