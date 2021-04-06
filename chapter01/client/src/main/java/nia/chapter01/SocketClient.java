package nia.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.err.println("3 args are required");
            return;
        }

        final String host = args[0];
        final int port = Integer.parseInt(args[1]);
        final String message = args[2];
        Socket socket = new Socket(host, port);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(message);
        printWriter.println("Done");
        printWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }
}
