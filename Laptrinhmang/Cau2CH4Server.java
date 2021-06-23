import java.net.*;
import java.io.*;
class  Cau2CH4Server
{
	public static void main(String[] args) 
	{
		try
		{
			ServerSocket ss = new ServerSocket(7);
			while(true)
			{
				try
				{
					Socket s = ss.accept();
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					while(true)
					{
						byte[] b = new byte[100];
						int kt=is.read(b);
						if(kt==-1) break; // Doc het du lieu trong Stream
						String str_kq = "";
						System.out.println("Client: "+(char)b[0]);
						if(kt == 1) 
							switch ((char)b[0])
							{
								case '0':str_kq="Khong";break;
								case '1':str_kq="Mot";break;
								case '2':str_kq="Hai";break;
								case '3':str_kq="Ba";break;
								case '4':str_kq="Bon";break;
								case '5':str_kq="Nam";break;
								case '6':str_kq="Sau";break;
								case '7':str_kq="Bay";break;
								case '8':str_kq="Tam";break;
								case '9':str_kq="Chin";break;
							}
						else str_kq="Khong phai so nguyen";
						byte[] b_send = str_kq.getBytes();
						os.write(b_send);
					}
					s.close();
				}
				catch (IOException e)
				{
					System.out.println("Connect Err!");
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("Server Socket Err!");
		}
		
	}
}
