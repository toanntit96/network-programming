import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class FReadUDPClient {
   public final static int ServerPort = 27;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length==0){
			System.out.println("Khong tim thay server");
		    return;
		    }
		System.out.println(args[0] + " Tiep tuc");
		try {
			DatagramSocket ds = new DatagramSocket();
			InetAddress ad = InetAddress.getByName(args[0]);
			while(true)	{		
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Nhap ten file \"vidu d:/btjava/hello.txt\" :");
				String st = br.readLine();
				byte[] data = st.getBytes();
				DatagramPacket in = new DatagramPacket(data,data.length,ad,ServerPort);
				ds.send(in);
				//if(st.equalsIgnoreCase("exit")) break;
				// nhan chuoi tu server
				byte[] buffer = new byte[60000];
				DatagramPacket incoming = new DatagramPacket(buffer,buffer.length);
				ds.receive(incoming);
				String kq =new String(incoming.getData(),0,incoming.getLength());
				System.out.println(kq);
		      }	
			 //ds.close();
			 //System.out.println("client dong noi ket");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
