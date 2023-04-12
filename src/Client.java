import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("localhost", 1254);
        Scanner ins = new Scanner(cs.getInputStream());
        PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);
        Scanner input = new Scanner(System.in);
        String receiveMsg;
        String sendMsg;
        do {
            receiveMsg = ins.nextLine();
            System.out.println("\tServer: " + receiveMsg);
            System.out.print("Client: ");
            sendMsg = input.nextLine();
            outs.println(sendMsg);
            outs.flush(); // added to flush the output stream
        } while (!receiveMsg.equals("bye"));
        ins.close();
        outs.close();
        cs.close();
    }
}
