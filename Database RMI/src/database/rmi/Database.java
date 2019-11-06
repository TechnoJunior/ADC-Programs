package database.rmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Database {
    public static void main(String[] args) {
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mca_buddy", "root","");
            Statement st=con.createStatement();
            String Query="select * from semester_wise";
            ResultSet rs=st.executeQuery(Query);
            while(rs.next())
            {
                System.out.println(rs.getInt("Sem_Id")+" "+rs.getString("Sem_Name"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
