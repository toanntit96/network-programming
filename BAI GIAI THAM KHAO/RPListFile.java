import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class RPListFile extends Thread {
  Socket s;
 public RPListFile (Socket s1){
	 s = s1;
 }
  
  public void run(){
	  
	  InputStream is;
	  OutputStream os;
	try {
		is = s.getInputStream();
		 os = s.getOutputStream();
		Scanner sn = new Scanner(is);
		PrintWriter pw = new PrintWriter(os);
		
		while(true) {	// Phuc vu cho 1 Client
			// Nhan yeu cau tu Client
			String yeucau = sn.nextLine();
			// Dieu kien de thoat
			if(yeucau.equals("EXIT")) break;
			// Xu ly yeu cau
			String thumuc = yeucau.substring(5);
			thumuc = thumuc.trim();
			File f = new File(thumuc);
			String kq[]=f.list();
			// Gui ket qua cho Client
			if(f.exists()) {
				// Gui so luong file va thu muc con
				pw.println("" + kq.length);
				pw.flush();
				// Gui danh sach file va thu muc con
				for(int i=0;i<kq.length;i++)
					pw.println(kq[i]);
				pw.flush();
			}
			else {
				pw.println("0");
				pw.flush();
			}			
		}
		s.close();
		System.out.println("Dong 1 noi ket");
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
  }
}
