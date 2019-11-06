
package database.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author TechnoBoy
 */
public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(5000);
        reg.rebind("show",new showDataImpl());
        System.out.println("Server is Ready !!!");
    }
}
