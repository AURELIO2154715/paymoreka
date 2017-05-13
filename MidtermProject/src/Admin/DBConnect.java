/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author Galo
 */
import java.sql.*;
public class DBConnect {
    Connection connection = null;
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
            System.out.println("connection nice!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
