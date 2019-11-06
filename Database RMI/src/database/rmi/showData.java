package database.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author TechnoBoy
 */
public interface showData extends Remote{
    public List<Students> getStudents() throws RemoteException;
}
