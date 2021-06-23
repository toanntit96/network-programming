import java.io.*;
import java.net.*;
class  KiemTra_Server
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
						byte[] b_clt = new byte[1000];
						int chk = is.read(b_clt);
						String str = new String(b_clt,0,chk);
						if(chk==-1) break; // Doc het du lieu trong Stream
						/////////////////////////////
						// Du lieu tu Client
						System.out.println("Noi dung file tu Client: " + str);
						/////////////////////////////
						String word = "CNTT2014";
						Boolean found;
						found = str.contains(word);
						//String str_kq = "";
						if(found) 
						{
							String FILENAME = "D://Laptrinhmang//danhsachcntt2014.txt";
							try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

								String sCurrentLine;
								while ((sCurrentLine = br.readLine()) != null) 
								{
									System.out.println(sCurrentLine);
									//byte[] b_send = sCurrentLine.getBytes();
									//os.write(b_send);
									//str_kq = str_kq + sCurrentLine + "\n";
								}

							} catch (IOException e) {
								e.printStackTrace();
							}									
						}
						//else str_kq = "Du lieu phia Client khong co tu 'CNTT2014' @@ ";
						//byte[] b_send = str_kq.getBytes();
						//System.out.println("Mang byte gui di: ");
						//System.out.println(new String(b_send));
						//os.write(b_send);  Loi lap vo tan  
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
