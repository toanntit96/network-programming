import java.net.*;
import java.io.*;
import java.util.Date;
class DemoMulticastServer 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket socket = new DatagramSocket(9013);
			while(true)
			{
				String date = new Date().toString();
				byte[] b_s = date.getBytes();
				InetAddress add = InetAddress.getByName("230.0.0.1");
				DatagramPacket dp =new DatagramPacket(b_s,b_s.length,add,901);
				socket.send(dp);
				System.out.println("Send at: " + date);
				Thread.sleep(5000);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
}
