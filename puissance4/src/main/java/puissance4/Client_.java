package puissance4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.io.*;

public class Client_ {
    
    public static final  int BUFFER_LENGTH = 1024;
    SocketChannel socket = null;
    public static void main(String[] args) {
        runClient();
    }

    public static void runClient() {
        Client_ c = new Client_();
        try{
            String firstName = "Connexion établie.. En attente du jeu";
            c.connect();
            c.write(firstName);
            /* c.close(); */
        }
        catch(IOException e){
            System.err.println("Could not connect to host " + e.getMessage());
        }
        
    }

    public void connect() throws IOException{
        System.out.println("Connecting to host...");
        socket = SocketChannel.open();
        socket.connect(new InetSocketAddress("localhost", 8000));        
        System.out.println("Connection established!");
    }

    public void write(String message) throws IOException{
        try{
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
            while(buffer.hasRemaining()){
                socket.write(buffer);
            }
            System.out.println("Message sent.");
        }
        catch(UnsupportedEncodingException e){
            System.err.println("Unsupported encoding ! " + e.getMessage());
        }
        
    }

    public void close(){
        try{
            socket.close();
        }
        catch(IOException e){
            System.err.println("Could not close socket");
        }
        
    }

}
