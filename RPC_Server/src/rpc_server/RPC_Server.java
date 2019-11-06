package rpc_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TechnoBoy
 */
public class RPC_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(4000);
        System.out.println("Server Ready!!!");
        
        Socket sock=ss.accept();
        System.out.println("Client Connected");
        
        BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream=sock.getOutputStream();
        
        PrintWriter pwrite=new PrintWriter(ostream,true);
        InputStream istream=sock.getInputStream();
        BufferedReader receiveRead=new BufferedReader(new InputStreamReader(istream));
        String op;
        while(true)
        {
            op=receiveRead.readLine();
            System.out.println("Operation : "+op);
            
            if(op.compareTo("date")==0)
            {          
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                System.out.println("Date : "+dateFormat.format(date));
                pwrite.println("Date : "+dateFormat.format(date));
            }
            else if(op.compareTo("time")==0)
            {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                System.out.println("Date : "+dateFormat.format(date));
                pwrite.println("Date : "+dateFormat.format(date));
            }
            System.out.flush();
        }
    }
    
}
