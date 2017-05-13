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
import javax.swing.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server {
    public static void main(String[] args) {
        try{
            PayrollServer server = new PayrollServerImpl();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("pyserver", server);
//            System.setProperty("java.rmi.server.hostname","10.10.27.132");
            System.out.print("ok!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
