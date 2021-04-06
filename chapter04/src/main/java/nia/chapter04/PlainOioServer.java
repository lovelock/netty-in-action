package nia.chapter04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 一个可以承载中等流量的服务器
 */
public class PlainOioServer {
    public void serve(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            for(;;) {
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                new Thread(() -> {
                    OutputStream os;
                    try {
                        os = clientSocket.getOutputStream();
                        os.write("Hi\r\n".getBytes(StandardCharsets.UTF_8));
                        os.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
