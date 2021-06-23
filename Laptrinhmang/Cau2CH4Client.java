import java.io.*;
import java.net.*;
import java.util.Scanner;
class  Cau2CH4Client
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
			String n = null;
			while(true)
			{
				System.out.print("Nhap so: ");
				n = Nhap.nextLine();
				System.in.skip(2);
				if(n.equals("@")) break;
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
