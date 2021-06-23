import java.net.*;
import java.io.*;
class DecToBin_Server 
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
						byte[] b_clt = new byte[100];
						int chk = is.read(b_clt);
						String str_num = new String(b_clt,0,chk);
						if(chk==-1) break;
						String kq = "";
						try
						{
							int num = Integer.parseInt(str_num);
							kq = Integer.toBinaryString(num);
							byte[] b_send = kq.getBytes();
							os.write(b_send);
						}
						catch (NumberFormatException e)
						{
							kq = "So khong hop le!!!";
							byte[] b_send = kq.getBytes();
							os.write(b_send);
						}
					}
					s.close();
				}
				catch (IOException e)
				{
					System.out.println("DISCONNECT!!!");
				}
				
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Server Socket Error!!!");
		}
		
	}
}
