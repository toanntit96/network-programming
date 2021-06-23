import java.util.Scanner;
import java.io.*;
import java.net.*;
class  KiemTra_Client
{
	public static void main(String[] args) 
	{
		// Xu ly file vong lap bat nhap lai duong dan file;
		File file = null;
		String str_send = "";
		do
		{
			// Nhap ten file
				System.out.print("Nhap ten file can doc: ");
				Scanner kb = new Scanner(System.in);
				String filename = kb.nextLine();
				file = new File(filename);
			try {
				// Doc noi dung file va hien thi
				FileInputStream f = new FileInputStream(file);
				
				System.out.println("Noi dung file:");
				while(true) 
				{
					int ch = f.read();
					if(ch==-1) break;
					System.out.print((char)ch);
					str_send+= (char)ch;
				}
				System.out.println();
				str_send += " \n";
				f.close();
				}
			catch(FileNotFoundException e) {
					System.out.println("File khong ton tai");
				}
			catch(IOException e) {
					System.out.println("Co loi khi doc noi dung file");
				}
		}
		while (!file.exists() || file.isDirectory());
		
		///////////////////////////////////////
		// Xu ly gui noi dung
		try
		{
			Socket s = new Socket("127.0.0.1",7);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true)
			{
				byte[] b_send = str_send.getBytes();
				os.write(b_send);
				byte[] b_srv = new byte[1000];
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
