import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 12345);

            // Create input and output streams for the socket
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            String message = "Hello, server!";
            out.println(message);
            System.out.println("Sent to server: " + message);

            // Receive a response from the server
            String response = in.nextLine();
            System.out.println("Received from server: " + response);

            // Close the streams and the socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
