import java.net.*;
import java.io.*;
class Cau1CH4Client 
{
	public static void main(String[] args) 
	{
		try
		{
			Socket s = new Socket(args[0],80);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			String str = "GET HTTP/1.0\n\n";
			byte[] b = str.getBytes();
			os.write(b);
			//int len = is.available(); // Khong chay duoc
			byte[] kq = new byte[500];
			is.read(kq);
			System.out.print(new String(kq));
		}
		catch (IOException e)
		{
			System.out.println("Loi tao socket!! :))");
		}
		
	}
}
