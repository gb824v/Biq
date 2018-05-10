package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new ChatServer().run();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(7000)) {
            boolean stop = false;
            int counter = 1;
            while (!stop) {
                Socket socket = serverSocket.accept(); //blocking...
                try {
                    ClientHandler clientHandler = new ClientHandler(this, socket, counter++);
                    clientHandlers.add(clientHandler);
                    clientHandler.start();
                }
                catch (IOException e) {
                    // TODO: log
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(int id, String msg) {
        for(ClientHandler client : clientHandlers) {
            client.sendMessage(id, msg);
        }
    }

    private void unregister(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }

    private static class ClientHandler extends Thread {
        private ChatServer server;
        private Socket socket;
        private final int id;
        private PrintStream outputStream;

        public ClientHandler(ChatServer server, Socket socket, int id) throws IOException {
            this.server = server;
            this.socket = socket;
            this.id = id;
            outputStream = new PrintStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
                String msg = "";
                BufferedReader inputStream;
                System.out.println("new client connected...");
                inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (!msg.equals("!")) {
                    msg = inputStream.readLine();
                    // old code before chat:
                    // outputStream.println("Server Got the Message..." + line);
                    server.broadcast(id, msg);
                    System.out.println(msg);
                }
            } catch (Exception e) {
                System.out.println("client disconnected during !");
            }
            finally {
                try {
                    server.unregister(this);
                    socket.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }

        public void sendMessage(int id, String msg) {
            if(id != this.id) {
                outputStream.println("" + id + ": " + msg);
            }
        }

    } // end of inner class ClientHandler

} // end of class ChatServer
