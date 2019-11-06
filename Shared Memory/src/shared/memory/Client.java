package shared.memory;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String args[]) throws IOException
    {
        Socket s=new Socket("localhost",2000);
        System.out.println(s);
    }
}
