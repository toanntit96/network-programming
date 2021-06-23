import java.io.*;
import java.net.*;
import java.util.Scanner;
class  Cau3CH4Client
{
	public static void main(String[] args) 
	{
		Scanner Nhap = new Scanner(System.in);
		try
		{
			Socket s = new Socket("127.0.0.1",7);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.out.println("Nhap @ DISCONNECT ");
			String str = null;
			while(true)
			{
				System.out.print("Nhap: ");
				str = Nhap.nextLine();
				System.in.skip(2);
				if(str.equals("@")) break;
				str=str.trim();
				String str_send = null;
				
				byte[] b = n.getBytes();
				os.write(b);
				byte[] kq = new byte[100];
				is.read(kq);
				System.out.println(new String(kq));
			}
		}
		catch (IOException e)
		{
			System.out.println("Loi tao socket!");
		}
		
	}
}
