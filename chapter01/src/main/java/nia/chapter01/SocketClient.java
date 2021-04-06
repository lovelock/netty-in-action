package nia.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Frost");
        printWriter.println("Done");
        printWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }
}
