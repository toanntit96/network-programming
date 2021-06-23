import java.net.*;
import java.io.*;
class UDP_StringLength_Server 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds = new DatagramSocket(7);
			byte[] b_clt = new byte[60000];
			while(true)
			{
				DatagramPacket dp = new DatagramPacket(b_clt,b_clt.length);
				ds.receive(dp);
				//String str = new String(dp.getData(),0,dp.getLength());
				
				int len = dp.getLength();

				String str_send = "Length = " +len;
				
				byte[] b_send = str_send.getBytes();
				InetAddress ia = dp.getAddress();
				int p = dp.getPort();
				DatagramPacket dp_send = new DatagramPacket(b_send,b_send.length,ia,p);
				ds.send(dp_send);
			}
		}
		catch (IOException e)
		{
			System.out.println("Datagram Socket Err!");
		}
		
	}
}
