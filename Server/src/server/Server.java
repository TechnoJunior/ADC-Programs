package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author TechnoBoy
 */
public class Server {

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
        String receiveMessage, sendMessge, op;
        int a,b,c;
        while(true)
        {
            op=receiveRead.readLine();
            System.out.println("Operation : "+op);
            a=Integer.parseInt(receiveRead.readLine());
            System.out.println("Parameter 1 : "+a);
            b=Integer.parseInt(receiveRead.readLine());
            System.out.println("Parameter 1 : "+b);
            
            if(op.compareTo("add")==0)
            {
                c=a+b;
                System.out.println("Addition = "+c);
                pwrite.println("Addition = "+c);
            }
            else if(op.compareTo("sub")==0)
            {
                c=a-b;
                System.out.println("Substraction = "+c);
                pwrite.println("Substraction = "+c);
            }
            else if(op.compareTo("mul")==0)
            {
                c=a*b;
                System.out.println("Multiplication = "+c);
                pwrite.println("Multiplication = "+c);
            }
            else if(op.compareTo("div")==0)
            {
                c=a/b;
                System.out.println("Division = "+c);
                pwrite.println("Division = "+c);
            }
            System.out.flush();
        }
    }
    
}
