import java.net.*;
import java.io.*;
class  UDPDemo_Client
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
			}
		}
		catch (IOException e)
		{
			System.out.println("Datagram Socket Err!");
		}
		
	}
}
