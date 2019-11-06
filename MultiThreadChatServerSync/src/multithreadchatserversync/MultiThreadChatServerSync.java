package multithreadchatserversync;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author TechnoBoy
 */
public class MultiThreadChatServerSync {

    // The server socket.
  private static ServerSocket serverSocket = null;
  // The client socket.
  private static Socket clientSocket = null;

  // This chat server can accept up to maxClientsCount clients' connections.
  private static final int maxClientsCount = 10;
  private static final clientThread[] threads = new clientThread[maxClientsCount];
  
    public static void main(String[] args) {
        //The Default Port Number.
        int portNumber=2000;
        if(args.length<1){
            System.out.println("Usage: java MultiThreadChatServerSync <portNumber>\n"+ "Now using port number=" + portNumber);
        }
        else{
            portNumber = Integer.parseInt(args[0]);
        }
        
        //Opening a server socket on the portNumber 
        try{
            serverSocket =new ServerSocket(portNumber);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        //Creating a client socket for new connection
        while(true)
        {
            try
            {
                clientSocket=serverSocket.accept();
                int i=0;
                for(i=0;i<maxClientsCount;i++)
                {
                    if(threads[i]==null){
                        (threads[i] = new clientThread(clientSocket, threads)).start();
                        break;
                    }
                    if(i==maxClientsCount)
                    {
                        PrintStream os=new PrintStream(clientSocket.getOutputStream());;
                        os.println("Server too busy. Try again later.");
                        os.close();
                        clientSocket.close();
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }

//The Chte client Thread
    private static class clientThread extends Thread{

        private String clientName = null;
        private DataInputStream is = null;
        private PrintStream os = null;
        private Socket clientSocket = null;
        private final clientThread[] threads;
        private int maxClientsCount;

        private clientThread(Socket clientSocket, clientThread[] threads) {
            this.clientSocket = clientSocket;
            this.threads = threads;
            maxClientsCount = threads.length;
        }
        
        public void run(){
            int maxClientsCount = this.maxClientsCount;
            clientThread[] threads = this.threads;
            
            try
            {
                is = new DataInputStream(clientSocket.getInputStream());
                os = new PrintStream(clientSocket.getOutputStream());
                String name;
                while (true) {
                    os.println("Enter your name.");
                    name = is.readLine().trim();
                    if (name.indexOf('@') == -1) {
                    break;
                    } 
                    else {
                        os.println("The name should not contain '@' character.");
                  }
                }
                /*Welcome the new client.*/
                os.println("Welcome " + name+ " to our chat room.\nTo leave enter /quit in a new line.");
                synchronized(this)
                {
                    for(int i=0;i<maxClientsCount;i++)
                    {
                        if (threads[i] != null && threads[i] == this) {
                            clientName = "@" + name;
                            break;
                        }
                    }
                    for (int i = 0; i < maxClientsCount; i++)
                    {
                        if (threads[i] != null && threads[i] != this)
                        {
                            threads[i].os.println("*** A new user " + name+ " entered the chat room !!! ***");
                        }
                    }
                }
                
                //Starting the converstation
                
                while(true)
                {
                    String line = is.readLine();
                    if (line.startsWith("/quit"))
                    {
                        break;
                    }
                    
                    //If the message is privately sent it to give client
                    if(line.startsWith("@"))
                    {
                        String[] words = line.split("\\s", 2);
                        if(words.length > 1 && words[1] != null)
                        {
                            words[1] = words[1].trim();
                            if(!words[1].isEmpty())
                            {
                                synchronized (this)
                                {
                                    for (int i = 0; i < maxClientsCount; i++)
                                    {
                                        if (threads[i] != null && threads[i] != this
                                        && threads[i].clientName != null
                                        && threads[i].clientName.equals(words[0]))
                                        {
                                            threads[i].os.println("<" + name + "> " + words[1]);
                                            //Message send private
                                            this.os.println(">" + name + "> " + words[1]);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        synchronized (this)
                        {
                            for (int i = 0; i < maxClientsCount; i++)
                            {
                                if (threads[i] != null && threads[i].clientName != null)
                                {
                                    threads[i].os.println("<" + name + "> " + line);
                                }
                            }
                        }
                    }
                }
                //The message is broadcasted pubilcally
                synchronized(this)
                {
                    for (int i = 0; i < maxClientsCount; i++)
                    {
                        if (threads[i] != null && threads[i] != this&& threads[i].clientName != null) 
                        {
                            threads[i].os.println("*** The user " + name + " is leaving the chat room !!! ***");
                        }
                    }
                }
                os.println("*** Bye " + name + " ***");

                //Creating the thread null for new client
                synchronized (this)
                {
                    for (int i = 0; i < maxClientsCount; i++)
                    {
                        if (threads[i] == this)
                        {
                            threads[i] = null;
                        }
                    }
                }

                //Close the all connection

                is.close();
                os.close();
                clientSocket.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }
}
