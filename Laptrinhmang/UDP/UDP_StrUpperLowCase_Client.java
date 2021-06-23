import java.net.*;
import java.io.*;
class UDP_StrUpperLowCase_Client 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds = new DatagramSocket();
			InetAddress ia = InetAddress.getLocalHost();
			
			while(true)
			{
				InputStreamReader isr =  new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				String str_send = br.readLine();
				if(str_send.equals("@")) break;
				byte[] b_send = str_send.getBytes();
				DatagramPacket dp = new DatagramPacket(b_send,b_send.length,ia,7);
				ds.send(dp);

				byte[] b_srv = new byte[60000];
				DatagramPacket dp_srv = new DatagramPacket(b_srv,b_srv.length);
				ds.receive(dp_srv);
				System.out.println(new String(dp_srv.getData(),0,dp_srv.getLength()));

				
				byte[] b_srv1 = new byte[60000];
				DatagramPacket dp_srv1 = new DatagramPacket(b_srv1,b_srv1.length);
				ds.receive(dp_srv1);
				System.out.println(new String(dp_srv1.getData(),0,dp_srv1.getLength()));
			}
		}
		catch (IOException e)
		{
			System.out.println("Datagram Socket Err!");
		}
		
	}
}