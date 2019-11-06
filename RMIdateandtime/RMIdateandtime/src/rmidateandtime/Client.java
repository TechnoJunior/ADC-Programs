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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Vasanth Raja Chittampally
*/
public class Client {
    public static void main(String[] args) throws NotBoundException {
        try {
            String url="rmi://127.0.0.1/time";
            TimeatServer ts=(TimeatServer) Naming.lookup(url);
             System.out.println(""+ts.showTime());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}