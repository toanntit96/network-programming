import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;
class DateTime_Srv 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket ds = new DatagramSocket(7);
			byte[] b_c = new byte[60000];
			while(true)
			{
				DatagramPacket in = new DatagramPacket(b_c,b_c.length);
				ds.receive(in);
				String str = new String(in.getData(),0,in.getLength());
				if(str.equals(" "))
				{
					Date dNow = new Date( );
					SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss ");
					String str_time = ft.format(dNow);
					DatagramPacket out = new DatagramPacket(str_time.getBytes(),str_time.getBytes().length,in.getAddress(),in.getPort());
					ds.send(out);
				}
				 
			}
		}
		catch (IOException e)
		{
			System.out.println("Hello World!");
		}
		
	}
}
