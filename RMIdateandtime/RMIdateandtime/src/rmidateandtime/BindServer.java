/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmidateandtime;

/**
 *
 * @author Student
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.Naming;
import java.rmi.registry.Registry;
/**
 *
 * @author Vasanth Raja Chittampally
 */
public class BindServer {
    public static void main(String[] args) {
        try {
//            TimeServerImpl tsi= new TimeServerImpl();
//            Naming.bind("time", tsi);
             TimeServerImpl tsi= new TimeServerImpl();
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
                        r.rebind("time", tsi);
        } catch (Exception ex) { 
            ex.printStackTrace();
        }
    }
}
