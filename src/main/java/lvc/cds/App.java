package lvc.cds;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Scanner;


import com.sun.net.httpserver.*;
public class App {
    
    public static void main(String args[]) throws IOException { 
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8002),0);
        System.out.println("Attempting to connect to server...");
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start(); 
    } 

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            URI reqURI = t.getRequestURI();
            String uri = reqURI.toString();
            String fileName = uri.substring(uri.lastIndexOf("/")+1);
            File file = new File(fileName);
            Scanner in = new Scanner(file);
            String response = "";
            while(in.hasNextLine()) {
                response = response +in.nextLine()+" ";
            }
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }


}