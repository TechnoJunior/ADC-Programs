package shared.memory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author TechnoBoy
 */
public class SharedMemory {
    
    static ServerSocket ss;
    static int count=0;
    public static void main(String[] args){
        try
        {
            ss=new ServerSocket(2000);
            while(true)
            {
                Socket s=ss.accept();
                count++;
                System.out.println("Count : "+count);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
}
