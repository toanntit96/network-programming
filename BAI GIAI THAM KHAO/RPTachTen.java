import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class RPTachTen extends Thread {
 private Socket s;
 public RPTachTen (Socket s1){
	 s = s1;
 }
  public void run (){
	  InputStream is;
	try {
		is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		BufferedReader br= new BufferedReader(new InputStreamReader(is));
		PrintWriter pw = new PrintWriter(os);
		
		 while(true){
			 //nhan chuoi
			String st =br.readLine();
			//is.skip(2);
			// System.out.println("chuoi vua nhan:" + st);
			 st = st.toUpperCase();
			 String ten = "";
			 if (st.equals("EXIT")) break;
			  st = st.trim();
		      ten = st.substring(st.lastIndexOf(" "),st.length());
			  pw.println(ten); pw.flush();
		 }
		 System.out.println("Dong ket noi");
		 s.close();
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
   }
}
