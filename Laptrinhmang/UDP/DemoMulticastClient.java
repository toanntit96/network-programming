import java.io.*;
import java.net.*;
class DemoMulticastClient 
{
	public static void main(String[] args) 
	{
		try
		{
			while(true)
			{
			MulticastSocket s =new MulticastSocket(901);
			InetAddress group = InetAddress.getByName("230.0.0.1");
			s.joinGroup(group);
			byte[] b = new byte[6000];
			DatagramPacket dp = new DatagramPacket(b,b.length);
			s.receive(dp);
			System.out.print("Server send: ");
			System.out.println(new String(dp.getData(),0,dp.getLength()));
			s.leaveGroup(group);
			s.close();
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
}
