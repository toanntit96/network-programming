import java.io.*;
import java.net.*;

public class ServerSSTachTen {
	public final static int defaultPort = 2017;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("server start ...");
			ServerSocket ss = new ServerSocket(defaultPort);
		
			while(true){
				Socket s = ss.accept();
				System.out.println("chap nhan ket noi tu client thu:");
				RPTachTen rp = new RPTachTen(s);
				rp.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
