import java.net.*;
import java.io.*;
class Multicast_ReadFile_Client 
{
	public static void main(String[] args) 
	{
		try
		{
			while(true)
			{
				MulticastSocket s =new MulticastSocket(900);
				InetAddress gr = InetAddress.getByName("230.0.0.1");
				s.joinGroup(gr);

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Nhap ten file \"vidu d:/btjava/hello.txt\" :");
				String st = br.readLine();
				byte[] data = st.getBytes();
				DatagramPacket in = new DatagramPacket(data,data.length,gr,9999);
				s.send(in);

				byte[] b = new byte[60000];
				DatagramPacket dp = new DatagramPacket(b,b.length);
				s.receive(dp);
				System.out.print("Server send: ");
				System.out.println(new String(dp.getData(),0,dp.getLength()));
				s.leaveGroup(gr);
				s.close();
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}
