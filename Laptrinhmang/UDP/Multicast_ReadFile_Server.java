import java.net.*;
import java.io.*;
class Multicast_ReadFile_Server 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds =new DatagramSocket(9999);
			byte[] buffer = new byte[60000];
			while(true)
			{
				DatagramPacket in = new DatagramPacket(buffer, buffer.length);
				ds.receive(in);
				String f = new String(in.getData(),0, in.getLength());
								//if(st.equalsIgnoreCase("exit")) break;
								//tao goi du lieu tra ve
				System.out.println(f);
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
