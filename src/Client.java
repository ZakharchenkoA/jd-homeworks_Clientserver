import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final int PORT = 31416;
    private static final String HOST = "127.0.0.1";
    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            String input;

            while (true) {
                System.out.println("Введите целое число...(\"end\" для завершения программы)");
                input = scanner.nextLine();
                out.println(input);
                if (input.equals("end")) break;
                System.out.println("SERVER: " + in.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}