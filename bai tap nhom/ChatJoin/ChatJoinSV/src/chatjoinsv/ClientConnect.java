/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatjoinsv;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClientConnect extends Thread {
	public Socket client;
	public Server server;
	private String nickName;
        private String pass;
        public String b;
        
	private DataOutputStream dos;
	private DataInputStream dis;
	private boolean run;
         private  ClassConnect a;

	public ClientConnect(Server server, Socket client){
		try {
			this.server=server;
			this.client=client;
			dos= new DataOutputStream(client.getOutputStream());
			dis= new DataInputStream(client.getInputStream());
			run=true;
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void run(){
		// xữ lý đăng nhập
		String msg=null;
		while(run){
                    // nhận nick name
			nickName=getMSG();
                        //thêm
                        pass=getMSG();
                        
                           a= new ClassConnect();
                          String b;
                         b = a.checkuser(nickName, pass);
                   //  JOptionPane.showMessageDialog(null, b);
                     
                        
                        
                    //    
			if(nickName.compareTo("0")==0){
				logout();
			}
			else {
                            if(b.equals("không"))
                                    
                                {
					sendMSG("0");
                                        continue;
                                }
                            else if(checkNick(nickName)){
					sendMSG("0");
                                        continue;
				}
				 else
                                { 
                                        server.user.append(nickName+" đã đăng nhập\n");
					server.sendAll(nickName,nickName+" đã vào phòng\n");
					server.listUser.put(nickName, this);
					server.sendAllUpdate(nickName);
					sendMSG("1");
                                        
					diplayAllUser();
                                  }
                            
					while(run){
                                           String stt1=getMSG();
                                           int stt;
                                          
                                              stt= Integer.parseInt(stt1);
                                                switch(stt){
							case 0:
								run=false;
								server.listUser.remove(this.nickName);
								exit();
								break;
							case 1:
								msg = getMSG();
                                                                // nick name tại đây
                                                               //  JOptionPane.showMessageDialog(null,"aa");
								server.sendAll(nickName,nickName+" : "+msg);
                                                                a.updateDB(nickName, "1", msg);
								break;
                                                        default:
                                                            break;
                                                     /*   case 112:
                                                          //  JOptionPane.showMessageDialog(null, "aa");
                                                            b = a.loadmsg();
                                                           //   JOptionPane.showMessageDialog(null, b);
                                                          server.sendAll1(nickName,nickName+" : "+msg);
                                                          
                                                            break;
                                                          
                                                         */ 
						}
                                        } 
				
			}
		}  
	}
	private void logout() {
		try {
			dos.close();
			dis.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void exit(){
		try {
			server.sendAllUpdate(nickName);
			dos.close();
			dis.close();
			client.close();
			server.user.append(nickName+" đã đăng xuất\n");
			server.sendAll(nickName,nickName+" đã thoát khỏi phòng\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private boolean checkNick(String nick){
		return server.listUser.containsKey(nick);
	}
	private void sendMSG(String data){
		try {
			dos.writeUTF(data);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void sendMSG(String msg1,String msg2){
		sendMSG(msg1);
		sendMSG(msg2);
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
        //Thêm
        
        public void getMSG(String ms1,String msg2)
        {
            getMSG();
            getMSG();
        }
        
        //
	private void diplayAllUser(){
		String name = server.getAllName();
		sendMSG("4");
                // sent client to update list online
		sendMSG(name);
	}
}

