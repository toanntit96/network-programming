/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatjoinclt;

/**
 *
 * @author Cold
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Client extends JFrame implements ActionListener{
	public JButton send,clear,exit,login,logout,loadmsg;
    public JPanel p_login,p_chat;
    public JTextField nick,nick1,message;
    JPasswordField pass ;
    public JLabel nick2;
 //public JT msg;
    public JTextArea msg,online;
    
    public Socket client;
    public DataStream dataStream;
    public DataOutputStream dos;
    public DataInputStream dis;

	public Client(){
		super("Room Chat Vĩnh Long : ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
		setSize(640, 480);
                
		
               //this.getContentPane().setBackground(Color.green);
            
             addItem();
           //   add(a);
		setVisible(true);
	}
//-----[ Tạo giao diện ]--------//
	private void addItem() {
		setLayout(new BorderLayout());

		exit = new JButton("Logout");
		exit.addActionListener(this);
		send = new JButton("Send");
		send.addActionListener(this);
                send.setBackground(Color.decode("#00CC99"));
		clear = new JButton("Clear");
		clear.addActionListener(this);
                clear.setBackground(Color.decode("#00CC99"));
		login= new JButton("Login");
		login.addActionListener(this);
		logout= new JButton("Exit");
		logout.addActionListener(this);
                // tạo login
                p_login = new JPanel();
		p_login.setLayout(new FlowLayout(FlowLayout.CENTER));
              //  p_login.setBackground(Color.decode("#FFCCCC"));
		p_login.add(new JLabel("User : "));
		nick1=new JTextField(10);
                p_login.add(nick1);
                p_login.add(new JLabel("Pass: "));
                pass= new JPasswordField(10);
		
                p_login.add(pass);
                
		p_login.add(login);
		p_login.add(logout);
           //    JLabel a = new JLabel(new ImageIcon("C:\\Users\\Cold\\coffee.png"));
              //  add(a);

		add(p_login,BorderLayout.NORTH);
                // tạo phòng chát
                
		p_chat = new JPanel ();
            //    p_chat.add(a);
		p_chat.setLayout(new BorderLayout());
                //
                p_chat.setBackground(Color.GREEN);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		nick = new JTextField(10);
                nick2= new JLabel();
                        
		p1.add(new JLabel("Hi: "));
		p1.add(nick2);
         
		p1.add(exit);
                p1.setBackground(Color.decode("#FFCCCC"));
                

		JPanel p2 = new JPanel();
               // p2.setBackground(Color.red);
		p2.setLayout(new BorderLayout());
                

		JPanel p22 = new JPanel();
                
		p22.setLayout(new FlowLayout(FlowLayout.CENTER));
                p22.setBackground(Color.LIGHT_GRAY);
		p22.add(new JLabel("<html><font color='red'><b>List online</b></font></html>"));
		p2.add(p22,BorderLayout.NORTH);
                
		online = new JTextArea(10,10);
		online.setEditable(false);
                online.setBackground(Color.decode("#FFFF99"));
		p2.add(new JScrollPane(online),BorderLayout.CENTER);
		p2.add(new JLabel("     "),BorderLayout.SOUTH);
		p2.add(new JLabel("     "),BorderLayout.EAST);
		p2.add(new JLabel("     "),BorderLayout.WEST);

		msg = new JTextArea("", 10, 20);
             //   msg.setText("<html> <font color=\"red\"> Hi </font></html>");
                msg.setBackground(Color.decode("#CCFFFF"));
              //  msg.setBackground(Color.green);
		msg.setEditable(false);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
             //   loadmsg =new JButton("Load Msg");
              ///  loadmsg.addActionListener(this);
              //  p3.add(loadmsg);
		p3.add(new JLabel("Messenger"));
		message = new JTextField(30);
		p3.add(message);
		p3.add(send);
		p3.add(clear);

		p_chat.add(new JScrollPane(msg),BorderLayout.CENTER);
		p_chat.add(p1,BorderLayout.NORTH);
		p_chat.add(p2,BorderLayout.EAST);
		p_chat.add(p3,BorderLayout.SOUTH);
		p_chat.add(new JLabel("     "),BorderLayout.WEST);
               
		p_chat.setVisible(false);
                
		add(p_chat,BorderLayout.CENTER);
		//-------------------------
                   // JLabel a = new JLabel(new ImageIcon("C:\\Users\\Cold\\coffee.png"));
               //add()
	}
//---------[ Socket ]-----------//
	public void go() {
		try {
			client = new Socket("192.168.137.1",2207);
			dos=new DataOutputStream(client.getOutputStream());
			dis=new DataInputStream(client.getInputStream());

			//client.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Lỗi kết nối, xem lại dây mạng đi hoặc room chưa mở.","Message Dialog",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Client().go();
	}
	private void sendMSG(String data){
		try {
			dos.writeUTF(data);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String getMSG(){
		String data=null;
		try {
			data=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void getMSG(String msg1, String msg2){
		int stt = Integer.parseInt(msg1);
		switch (stt) {
		// tin nhắn của những người khác
		case 3:
			this.msg.append(msg2);
			break;
		// update danh sách online
		case 4:
			this.online.setText(msg2);
			break;
		// server đóng cửa
		case 5:
			dataStream.stopThread();
			exit();
			break;
		// bổ sung sau
                /*case 6:
                    //JOptionPane.showMessageDialog(null, "aa");
                  // this.msg.removeAll();
                   this.msg.append(msg2);
                   this.msg.append(msg1);
                    break;*/
		default:
			break;
		}
	}
//----------------------------------------------
	private void checkSend(String msg){
		if(msg.compareTo("\n")!=0){
                    
                         Font font1 = new Font("SansSerif", Font.BOLD, 20);
                     
			this.msg.append("Me :"+msg);
			sendMSG("1");
                        // duy trì kết nối 
			sendMSG(msg);
                        Font font2 = new Font("SansSerif", Font.BOLD, 10);
                        this.msg.setFont(font2);
		}
	}
	public boolean checkLogin(String nick, String pass){
		if(nick.compareTo("")==0)
			return false;
		else if(nick.compareTo("0")==0){
			return false;
		}
		else{
                    // gửi nick tại đây
			sendMSG(nick);
                        sendMSG(pass);
                       // JOptionPane.showMessageDialog(null, getMSG());
                        
			int sst = Integer.parseInt(getMSG());
                    //    JOptionPane.showMessageDialog(null, ""+sst);
			if(sst==0)
				 return false;
                       
                                return true;
		}
	}
//
        
        
        
        
//       
	private void exit(){
		try {
			sendMSG("0");
                        // sent 0 to exit
			dos.close();
			dis.close();
			client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}
        
        	private void exit1(){
		try {
			sendMSG("0");
                        // sent 0 to exit
			dos.close();
			dis.close();
			client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//System.exit(0);
	}
        
        
        
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit){
			 exit1();
                                   this.hide();
                               new Client().go();
		}
		else if(e.getSource()==clear){
			message.setText("");
		}
		else if(e.getSource()==send){
			checkSend(message.getText()+"\n");
			message.setText("");
		}
		else if(e.getSource()==login){
                        // gửi nick tại đây
			if(checkLogin(nick1.getText(),pass.getText())){
				p_chat.setVisible(true);
				p_login.setVisible(false);
				nick2.setText(nick1.getText());
				//nick2.setEditable(false);
                                nick2.setForeground(Color.blue); 
                             
				this.setTitle("ROOM CHÁT VĨNH LONG ");
                                
                                //
                               // msg.setBackground(Color.green);
                                //
                               
				msg.append("Chào mừng "+nick1.getText()+" đến với phòng chát \n");
				dataStream = new DataStream(this, this.dis);
			}
			else{
                                    
				JOptionPane.showMessageDialog(this,"Tài khoản hoặc mật khẩu không hợp lệ, bạn vui lòng nhập lại.","Cảnh báo",JOptionPane.WARNING_MESSAGE);
                                    //  exit1();
                                  //  this.hide();
                              //  new Client().go();
                            
			}
		}
		else if(e.getSource()==logout){
                                exit();
		}
                else if(e.getSource()==loadmsg){
			// something here
                        sendMSG("112");
                                        
                        
		}
	}


}
