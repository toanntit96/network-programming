import java.net.*;
import java.io.*;
import java.util.Scanner;
class DecToBin_Client 
{
	public static void main(String[] args) 
	{
		Scanner Nhap = new Scanner(System.in);
		try
		{
			Socket s = new Socket("127.0.0.1",7);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true)
			{
				System.out.print("Nhap chuoi so: ");
				String str_num = Nhap.nextLine();
				System.in.skip(2);
				if(str_num.equals("@")) break;
				byte[] b_send = str_num.getBytes();
				os.write(b_send);
				byte[] b_srv = new byte[100];
				is.read(b_srv);
				System.out.println(new String(b_srv));
			}
		}
		catch (IOException e)
		{
			System.out.println("Connect Error!");
		}
		
	}
}
