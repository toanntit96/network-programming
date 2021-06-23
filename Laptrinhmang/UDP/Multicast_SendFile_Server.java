import java.io.*;
import java.net.*;
import java.util.Date;
class Multicast_SendFile_Server 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds =new DatagramSocket(9999);
			while(true)
			{
				String f = "D:\\Laptrinhmang\\file_test.txt";
				byte[] b_send = new byte[60000];
				try
				{
					FileInputStream f_is = new FileInputStream(f);
					int n = f_is.read(b_send);
					System.out.println("n: "+ n);
					InetAddress ia = InetAddress.getByName("230.0.0.1");
					DatagramPacket dp = new DatagramPacket (b_send,n,ia,900);
					ds.send(dp);
					System.out.println("Send...");
					try
					{
						Thread.sleep(3000);
					}
					catch (InterruptedException e)
					{
						System.out.println(e);
					}
					
				}
				catch (FileNotFoundException e)
				{
					System.out.println(e);
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		
	}
}
