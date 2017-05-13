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
import java.sql.ResultSet;
public interface PayrollServer extends Remote {
    //login
    public boolean login(String username,String password) throws RemoteException;
    //firstName.getText(),middleName.getText(), gender, address.getText(), eMail.getText(),
                      // jobTitle.getText(), bday, pay_type.getSelectedItem()
    public void addEmployee(String firstname, String middlename, String lastname, String gender, String address, 
            String email, String jobTitle, String bday, String pay_type, String salary) throws RemoteException;
    
    public void editEmployee() throws RemoteException;

    
    
}
