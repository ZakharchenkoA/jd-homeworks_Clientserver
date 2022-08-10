import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 31416;

    public static void main(String[] args) throws IOException{

        while (true) {
            try (ServerSocket servSocket = new ServerSocket(PORT);
                 Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String userInput;
                long number;

                while ((userInput = in.readLine()) != null) {
                    if (userInput.equals("end")) {
                        break;
                    } else
                        number = Long.parseLong(userInput);
                    if (number == 0) {
                        out.println(number + "-й член ряда Фибоначчи равен 0");
                    } else if (number == 1) {
                        out.println(number + "-й член ряда Фибоначчи равен 1");
                    } else {
                        long a = 0;
                        long b = 1;
                        for (long i = 2; i <= number; ++i) {
                            long next = a + b;
                            a = b;
                            b = next;
                        }
                        out.println(number + "-й член ряда Фибоначчи равен " + b + " (Нумерация начинается с 0)");
                    }
                }
            }
        }
    }
}