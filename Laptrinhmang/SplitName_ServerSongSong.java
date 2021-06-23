import java.net.*;
import java.io.*;
class SplitName_ServerSongSong 
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
					RequestProcess rp = new RequestProcess(s);
					rp.start();
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
class RequestProcess extends Thread
{
	private Socket s;
	public RequestProcess (Socket s1)
	{
		s=s1;
	}
	public void run()
	{
		try
		{
				InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					while(true)
					{
						byte[] b_clt = new byte[1000];
						int n = is.read(b_clt);
						String str_clt = new String(b_clt,0,n);
						if(n==-1) break;
						str_clt = str_clt.trim();
						int start = str_clt.length();
						for(int i=str_clt.length()-1;i>=0;i--)
						{
							if(String.valueOf(str_clt.charAt(i)).equals(" ")) break;
							start--;
						}
						String str_send = "Name: " + str_clt.substring(start);
						byte[] b_send = str_send.getBytes();
						os.write(b_send);
						
					}
		}
		catch (IOException e)
		{
			System.out.println("Server Socket Err!");
		}
					
	}
}