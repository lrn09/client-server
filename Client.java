package com.company.javaCore.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8090;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String resp = in.readLine();
            System.out.println(resp);
            out.println("Netology");

            String resp1 = in.readLine();
            System.out.println(resp1);
            out.println("yes");

            String resp2 = in.readLine();
            System.out.println(resp2);

            String resp3 = in.readLine();
            System.out.println(resp3);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
