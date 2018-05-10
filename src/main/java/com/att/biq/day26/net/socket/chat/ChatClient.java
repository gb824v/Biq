package sockets;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7000)) {

            // server listener thread
            new Thread(() -> {
                try {
                    BufferedReader bufferedReader =
                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    boolean stop = false;
                    String line;
                    while(!stop && (line = bufferedReader.readLine()) != null){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("disconnected from server");
                    // TODO: close the client

                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            String msg;
            do {
                System.out.println("Your message: ");
                msg = scanner.nextLine();
                outputStream.println(msg);
            }while(!msg.equals("!"));
        } catch (IOException e) {
            System.out.println("disconnected from server");
            // TODO: close the client
        }
    }



}
