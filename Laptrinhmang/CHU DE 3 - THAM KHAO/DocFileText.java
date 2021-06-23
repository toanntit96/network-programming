import java.util.Scanner;
import java.io.*;
class DocFileText {
	public static void main(String[] args) {
		try {
			// Nhap ten file
			System.out.print("Nhap ten file can doc: ");
			Scanner kb = new Scanner(System.in);
			String filename = kb.nextLine();
			// Doc noi dung file va hien thi
			FileInputStream f = new FileInputStream("d:/btjava/hello.txt");
			System.out.println("Noi dung file:");
			while(true) 
			{
				int ch = f.read();
				if(ch==-1) break;
				System.out.print((char)ch);
			}
			f.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File khong ton tai");
		}
		catch(IOException e) {
			System.out.println("Co loi khi doc noi dung file");
		}
	}
}
