package database.rmi;

import com.mysql.jdbc.Connection;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class showDataImpl extends UnicastRemoteObject implements showData{

    public showDataImpl() throws RemoteException {
    }

    List<Students> list;
    Connection con;
    Statement st;
    @Override
    public List<Students> getStudents() throws RemoteException {
     
        try {
            list = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mtnl", "root","");
            Statement st=con.createStatement();
            String query="select * from records";
         try (ResultSet rs = st.executeQuery(query)) {
             while(rs.next())
             {
                 int id=rs.getInt("Bill_NO");
                 String name=rs.getString("Customer_Name");
                 String address=rs.getString("Customer_Address");
                 int bill=rs.getInt("Bill_Ammount");
                 int due=rs.getInt("Due_Ammount");
                 System.out.println("done");
                 
                 Students students = new Students();
                 students.setId(id);
                 students.setName(name);
                 students.setAddress(address);
                 students.setBillamt(bill);
                 students.setDueamt(due);
                 list.add(students);
             }
         }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(showDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return list;
    }
}
