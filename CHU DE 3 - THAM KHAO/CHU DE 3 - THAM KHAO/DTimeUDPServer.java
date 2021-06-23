import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class DTimeUDPServer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			DatagramSocket ds =new DatagramSocket(13);
			System.out.println("Da khoi tao server..");
			while(true){
				byte[] bufferIn = new byte[60000];	
					DatagramPacket in = new DatagramPacket(bufferIn, bufferIn.length);
						ds.receive(in);
					//String st = new String(in.getData(),0, in.getLength());
					//if(st.equalsIgnoreCase("exit")) break;
					//tao goi du lieu tra ve
						byte[] bufferOut = new byte[60000];
						String date = new Date().toString();
						bufferOut= date.getBytes();
						DatagramPacket out = new DatagramPacket(bufferOut, bufferOut.length,in.getAddress(),in.getPort());
						ds.send(out);
						Thread.sleep(5000);
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
