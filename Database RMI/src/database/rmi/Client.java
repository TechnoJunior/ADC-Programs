package database.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) {
        try {
            showData sd=(showData) Naming.lookup("rmi://localhost:5000/show");
            List<Students> list=(List) sd.getStudents();
            System.out.println("Cust_Name --> Cust_Address --> Bill_Amt --> Due_Amt \n");
            list.stream().forEach((s) -> {
                System.out.println(s.getId()+" --> "+s.getName()+" --> "+s.getAddress()+" --> "+s.getBillamt()+" --> "+s.getDueamt());
            });
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
