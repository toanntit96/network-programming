import java.io.*;
import java.net.*;
class DateTime_Client 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds = new DatagramSocket();
			InetAddress srv = InetAddress.getByName("127.0.0.1");
			while(true)
			{
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				String str = br.readLine();
				if(str.equals("@")) break;
				DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length,srv,7);
				ds.send(dp);
				byte[] b_i = new byte[60000];
				DatagramPacket dp_in = new DatagramPacket(b_i,b_i.length);
				ds.receive(dp_in);
				System.out.println(new String(dp_in.getData(),0,dp_in.getLength()));
			}
		}
		catch (IOException e)
		{
			System.out.println("Hello World!");
		}
		
	}
}
