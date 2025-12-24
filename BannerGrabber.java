import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class BannerGrabber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Target IP: ");
        String host = scanner.nextLine();

        System.out.print("Enter Port (e.g., 22, 80, 443): ");
        int port = scanner.nextInt();

        int timeout = 3000;

        System.out.println("[*] Attempting to grab banner from " + host + ":" + port + "...");

        try (Socket socket = new Socket()) {
        
            socket.connect(new InetSocketAddress(host, port), timeout);

            
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);

            if (bytesRead != -1) {
                String banner = new String(buffer, 0, bytesRead).trim();
                System.out.println("[!] Banner Found: " + banner);
            } else {
                System.out.println("[-] Connection established, but no banner was returned.");
            }
        } catch (Exception e) {
            System.out.println("[X] Connection Failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
