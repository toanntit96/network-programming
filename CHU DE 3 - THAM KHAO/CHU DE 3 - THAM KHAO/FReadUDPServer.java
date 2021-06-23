import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class FReadUDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket ds =new DatagramSocket(27);
			System.out.println("Da khoi tao server..");
			byte[] buffer = new byte[60000];
			while(true){
				DatagramPacket in = new DatagramPacket(buffer, buffer.length);
				ds.receive(in);
					String st = new String(in.getData(),0, in.getLength());
					//if(st.equalsIgnoreCase("exit")) break;
					//tao goi du lieu tra ve
					System.out.println(st);
					byte[] data = new byte[60000];
					try {
					 FileInputStream is = new FileInputStream(st);
					 int n = is.read(data);
					 System.out.println("n: "+ n);
			     // Tao goi tin tra ve noi dung file	
		             DatagramPacket out = new DatagramPacket(data,n,in.getAddress(),in.getPort());
		             ds.send(out);
		               		           
				}catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		        }

					
			}		
			//ds.close();
			//System.out.println("Server dong noi ket");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
