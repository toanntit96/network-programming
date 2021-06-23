import java.net.*;
import java.io.*;
class UDPDemo_Server
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
				System.out.println(str);
				InetAddress ia = dp.getAddress();
				int p = dp.getPort();
				String str_send = "OKE ROI DO";
				byte[] b_send = str_send.getBytes();
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
