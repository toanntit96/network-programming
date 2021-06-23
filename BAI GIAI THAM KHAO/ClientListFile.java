import java.util.Scanner;
import java.util.NoSuchElementException;
import java.net.*;
import java.io.*;
class ClientListFile {
	public static void main(String[] args) {
		try {
			// Nhap dia chi Server
			Scanner kb = new Scanner(System.in);	// noi voi ban phim
			System.out.print("Nhap dia chi: ");
			String diachi = kb.nextLine();
			// Tao Socket noi ket den Server
			Socket s = new Socket(diachi,2222);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sn = new Scanner(is);	// noi voi Server
			while(true) {
				// Nhap tu ban phim ten thu muc
				System.out.print("Nhap ten thu muc: ");
				String thumuc = kb.nextLine();
				// Dieu kien de thoat
				if(thumuc.equals("EXIT")) {
					pw.println("EXIT"); pw.flush();
					break;
				}
				// Gui yeu cau cho Server
				pw.println("LIST " + thumuc);
				pw.flush();
				// Nhan ket qua tra ve tu Server va hien thi
				System.out.println("Ket qua nhan ve:");
				// Nhan ve so luong file va thu muc con
				String sl = sn.nextLine();
				int n = Integer.parseInt(sl);
				if(n==0)
					System.out.println("Khong ton tai thu muc");
				else   // Nhan ve danh sach file va thu muc con
					for(int i=0;i<n;i++) {
						String kq = sn.nextLine();
						System.out.println("  " + kq);
					}
			}
			s.close();
			System.out.println("Dong noi ket");
		}
		catch(IOException e) {
			System.out.println("Co loi khi thuc thi Client");
		}
	}
}
