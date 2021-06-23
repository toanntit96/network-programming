import java.net.*;
import java.io.*;
class UDP_StrUpperLowCase_Server 
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

				String str = new String(dp.getData(),0,dp.getLength());
				String str_up = "-Chuoi HOA: " + str.toUpperCase();
				String str_low ="-Chuoi thuong: " + str.toLowerCase();
				
				byte[] b_send = str_up.getBytes();
				byte[] b_send2 = str_low.getBytes();

				InetAddress ia = dp.getAddress();
				int p = dp.getPort();
				DatagramPacket dp_send = new DatagramPacket(b_send,b_send.length,ia,p);
				ds.send(dp_send);
				dp_send = new DatagramPacket(b_send2,b_send2.length,ia,p);
				ds.send(dp_send);

			}
		}
		catch (IOException e)
		{
			System.out.println("Datagram Socket Err!");
		}
		
	}
}
