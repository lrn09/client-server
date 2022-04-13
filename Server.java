package com.company.javaCore.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8090;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))){
            System.out.println("New connection accepted");

            out.println("Write your name:");
            final String name = in.readLine();
            System.out.println(name);

            out.println("Are you child? (yes/no)");
            String ageCheck = in.readLine();
            System.out.println(ageCheck);
            if (ageCheck.equals("yes")){
                out.println(String.format("Welcome to the kids area, %s Let's play!", name));
            }else {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }

            out.println(String.format("%s, your port is %d", name, clientSocket.getPort()));

        }

    }
}
