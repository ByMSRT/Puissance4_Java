package puissance4;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Communicator {

    static dataNetwork dn = null;
    static Host server = null;
    static Client client = null;
    static boolean isHost = false;

    public static void createServ(String ip) throws IOException {
        String message = "";

        isHost = (ip.length() == 0);
        System.out.println(isHost);
        if(ip.length() > 0) {
            client = new Client();
            try {
                client.connect(ip);
            } catch (IOException e) {
                System.out.println("Could not connect to target " + ip + " : " + e.getMessage());
            }
            message = sendMessage();
        } else {
            server = new Host();
            server.accept();
        }

        while(!message.equals("Quit")){
            message = (isHost ? server.read() : client.read());
            if (message.equals("Quit")) {
                break;
            }
            System.out.println(">> " + message + "\n");
            message = sendMessage();
        }
        System.out.println("Fermeture");
        System.out.println("Communication terminée");
        System.exit(0);
    }

    public static String getMessageFromConsole() throws IOException {
        System.out.print("> ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = br.readLine();
        if(input == ""){
            throw new IOException("Input cannot be empty.");
        }
        return input;
    }
    public static String sendMessage(){
        try{
            String message = getMessageFromConsole();
            if (isHost) {
                server.write(message);
            } else {
                client.write(message);
            }
            return message;
        }
        catch(IOException e){
            System.err.println("Could not send message. " + e.getMessage());
        }
        return "";
    }
}

class dataNetwork {
    protected static final  int BUFFER_LENGTH = 1024;
    protected static final int PORT = 4004;

    protected SocketChannel socket = null;

    public void close() throws NullPointerException {
        try{
            socket.close();
        }
        catch(IOException e){
            System.err.println("Could not close socket");
        }   
    }

    public String read(){
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_LENGTH);
        try {
            int bytesRead = socket.read(buffer);
            try{
                String message = new String(buffer.slice(0, bytesRead).array(), "UTF-8");
                return message;
            }
            catch(UnsupportedEncodingException e){
                System.err.println("Unsupported encoding!");
            }
        }
        catch(IOException e){
            System.err.println("Could not read from socket : " + e.getMessage());
        }
        return "";
        
    }

    public void write(String message) throws IOException {
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
}

class Host extends dataNetwork {

    public void accept(){
        System.out.println("En attente de la connexion client sur le port : " + PORT);
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(PORT));
            socket = ssc.accept();
            System.out.println("Connexion établie !");
        }
        catch(IOException e){
            System.err.println("Impossible de lancer le serveur" + e.getMessage());
        }
        
    }
}

class Client extends dataNetwork {


    public void connect(String ipAdress) {
        System.out.println("Connexion en cours à l'hote sur le port : " + PORT);
        socket = SocketChannel.open();
        socket.connect(new InetSocketAddress(ipAdress, PORT));        
        System.out.println("Connexion établie !");
    }
}
