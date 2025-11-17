//USE THIS VERSION
import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port "+port);
        
    }
    public void acceptClient() throws IOException {
        // out = socket.getOutputStream();
        // in = socket.getInputStream();
        socket = serverSocket.accept();
        InputStream i = socket.getInputStream();
        OutputStream o = socket.getOutputStream();
        in = new Scanner(i);
        out = new PrintWriter(o, true);
    }
    public String receiveMessage() {
        return in.nextLine();
    }
    public void sendMessage(String message) {
        out.println(message);
    }
    public void close() {
    }
    public static void main(String[] args) throws Exception {
        SimpleServer s = new SimpleServer(8080);
        s.acceptClient();
        FileOperator file = new FileOperator("index.html");
        // while (true){
        //     String user = s.receiveMessage();
        //     System.out.println("User: "+user);
        //     if (user.equals("exit")){
        //         break;
        //     }
        //     String response = file.readLines();
        //     s.sendMessage(response);
        // }
        // s.close();   
        String user;
        user = s.receiveMessage();
        System.out.println("Headers: "+user);

        s.sendMessage("HTTP/1.1 200 OK");
        s.sendMessage("Content-Type text/html");
        s.sendMessage("");

        String response = file.readLines();
        while (response != null){
            s.sendMessage(response);
            response = file.readLines();
        }
        s.close();
    }
}

//OLD VERSION
// import java.io.*;
// import java.net.*;
// import java.util.*;

// public class SimpleServer {
//     private ServerSocket serverSocket;
//     private Socket socket;
//     private PrintWriter out;
//     private Scanner in;
//     public SimpleServer(int port) throws IOException {
//         serverSocket = new ServerSocket(port);
//         System.out.println("Server started on port "+port);
        
//     }
//     public void acceptClient() throws IOException {
//         // out = socket.getOutputStream();
//         // in = socket.getInputStream();
//         socket = serverSocket.accept();
//         InputStream i = socket.getInputStream();
//         OutputStream o = socket.getOutputStream();
//         in = new Scanner(i);
//         out = new PrintWriter(o, true);
//     }
//     public String receiveMessage() {
//         return in.nextLine();
//     }
//     public void sendMessage(String message) {
//         out.println(message);
//     }
//     public void close() {
//     }
//     public static void main(String[] args) throws IOException {
//         try { 
//         SimpleServer s = new SimpleServer(8888);
//         s.acceptClient();
//         String user = s.receiveMessage();
//         s.sendMessage("Received: "+ user);
//         s.close();
//         }
//         catch (Exception e){
//             System.out.println("EXCEPTION OCCURED");
//             e.printStackTrace();
//         }
//     }
// }