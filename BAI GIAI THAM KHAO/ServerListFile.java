import java.util.Scanner;
import java.net.*;
import java.io.*;
class ServerList {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 2222
			ServerSocket ss = new ServerSocket(2222);
			while(true) {
				try {
					// Chap nhan cho 1 Client noi ket
					Socket s = ss.accept();
					RPListFile rp =new RPListFile(s);
					rp.start();
					System.out.println("chap nhat phuc vu 1 Client");
					
				}
				catch(IOException e) {
					System.out.println("Co loi khi phuc vu 1 Client");
				}
			}
		}
		catch(IOException e) {
			System.out.println("Khoi khoi tao duoc Server");
		}
	}
}
