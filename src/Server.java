import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1254);
        Socket cs = ss.accept();
        Scanner ins = new Scanner(cs.getInputStream());
        PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);
        Scanner input = new Scanner(System.in);
        String receiveMsg;
        String sendMsg;
        do {
            System.out.print("Server: ");
            sendMsg = input.nextLine();
            outs.println(sendMsg);
            receiveMsg = ins.nextLine();
            System.out.println("\tClient:" + receiveMsg);
            ins = new Scanner(cs.getInputStream());
        } while (!receiveMsg.equals("bye"));
        outs.close();
        ins.close();
        cs.close();
        ss.close();
    }
}
