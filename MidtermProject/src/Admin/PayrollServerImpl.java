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
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class PayrollServerImpl extends UnicastRemoteObject implements PayrollServer {
    public PayrollServerImpl() throws RemoteException{
        
    }
    public boolean login(String username,String password) throws RemoteException{
        boolean x = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
            String insQuery = "SELECT username,password from users where username='"+username+"'and password ='"
                    + password+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(insQuery);
            
 
                if(rs.next()){
                    x = true;
                    
                }else{
                    x = false;
                    JOptionPane.showMessageDialog(null, "Wrong Credentials!");
                }    
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }
    public void addEmployee(String firstname, String middlename, String lastname, String gender, String address, 
            String email, String jobTitle, String bday, String pay_type, String salary) throws RemoteException{
        Calendar now = Calendar.getInstance();   // Gets the current date and time
        int year = now.get(Calendar.YEAR);   //gets the current year
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        
       Double salary_parsed = Double.parseDouble(salary);
        
        String dateToday = (Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day));
//               PreparedStatement ps = con.prepareStatement(insQuery);
//               ps.setString(1, name); //parameter 1 = una parameter 2 value
//               ps.setString(2, pw);
//                int i = ps.executeUpdate();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
            String insQuery ="INSERT into employees (first_name,last_name,address,created_at,updated_at,position,email,gender,"
                    + "birthdate,middle_name,pay_type,salary) Values (?,?,?,?,?,?,?,?,?,?,?,?)" ;
             System.out.print(insQuery);
             PreparedStatement ps = con.prepareStatement(insQuery);
             ps.setString(1, firstname);
             ps.setString(2, lastname);
             ps.setString(3, address);
             ps.setString(4, dateToday);
             ps.setString(5, dateToday);
             ps.setString(6, jobTitle );
             ps.setString(7, email);
             ps.setString(8, gender);
             ps.setString(9, bday);
             ps.setString(10, middlename);
             ps.setString(11, pay_type);
             ps.setDouble(12, salary_parsed);
             int i = ps.executeUpdate();
          
 
                if(i>0){
                   System.out.print("success");
                    
                }else{
                   System.out.print("Failed");
                }    
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void editEmployee() throws RemoteException{
        
    }
   
    
}
