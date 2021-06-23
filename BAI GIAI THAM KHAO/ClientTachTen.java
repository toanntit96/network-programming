import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTachTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s= new Socket("127.0.0.1",2017);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			BufferedReader keybroad= new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(os);
			while(true){
				System.out.println("nhap ho va ten:");
				String st = keybroad.readLine();
				//System.in.skip(2);
				//byte b[] = str.getBytes(); 
				pw.println(st); pw.flush();
					//System.in.skip(2);
				if (st.equalsIgnoreCase("exit")) break;
				// nhan ket qua tra ve	
				String str1 = br.readLine(); 
				System.out.println("Ten la:" + str1);
				}
			System.out.println("Dong noi ket"); 
			s.close();
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
