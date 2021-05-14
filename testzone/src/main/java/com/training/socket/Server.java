package com.training.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.connectToServer();
    }

    int port = 4444;

    public void connectToServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("___");
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = in.readLine();
            if (request == null) {
                continue;
            }
            String requestType = request.split(" ")[0];
            String requestCommand = request.split(" ")[1];

            Controller controller = new Controller();
            String response = controller.respond(requestCommand);
            System.out.println(response);
            out.println(response);

            clientSocket.close();
        }
    }
}

//                System.out.println(request);
//                out.write("HTTP/1.0 200 OK\r\n");
//                out.write("Content-Type: text/html\r\n");
//                out.write("\r\n");
//                out.println(String.format("<h1>%s</h1>", request));
//                out.println(String.format("<p>%s</p>", request));

// https://stackoverflow.com/questions/10788125/a-simple-http-server-with-java-socket