package com.javarush.task.task30.task3008;

import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server started...");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Something wrong, Server socket closed");
        }


    }

    private static class Handler extends Thread implements AutoCloseable {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void close() throws Exception {
            this.close();
        }
    }
}
