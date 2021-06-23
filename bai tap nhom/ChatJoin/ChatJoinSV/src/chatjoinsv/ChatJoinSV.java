/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatjoinsv;


import javax.swing.JOptionPane;

public class ChatJoinSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassConnect A= new ClassConnect();
       String b=A.loadmsg();
  JOptionPane.showMessageDialog(null,b);


    }
    
}
