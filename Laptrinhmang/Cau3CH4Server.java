import java.net.*;
import java.io.*;
class Cau3CH4Server 
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
					while (true)
					{
						byte[] b = new byte[100];
						if(is.read(b)==-1) break;
						String str_client = new String(b);
						char pt = str_client.charAt(0);
						int th1=0, th2=0;
						int t=0;
						// xu ly toan hang 1
						for(int i=2;i<str_client.length();i++)  	
						{
							if(str_client.charAt(i) == ' ') break;
							t++;
						}
						
						// xu ly toan hang 2
						int vt_th2 = t+4;    // bo di: pheptoan' 'th1' 'th2

						try
						{
							th1 = Integer.parseInt(str_client.substring(2,t));
							th2 = Integer.parseInt(str_client.substring(vt_th2-1,str_client.length()-vt_th2));
						}
						catch (NumberFormatException e)
						{
							System.out.println("Cannot conver string to number");
						}
						System.out.println(pt);
						System.out.println(th1);
						System.out.println(th2);
						
					}
					s.close();
				}
				catch (IOException e)
				{
					System.out.println("Server Socket Err!");
				}
			}

		}
		catch (IOException e)
		{
			System.out.println("Server Socket Err!");
		}
		
	}
}
