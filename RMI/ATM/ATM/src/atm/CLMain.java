/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.Color;
import java.awt.Image;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Cold
 */
public class CLMain extends javax.swing.JFrame {

    /**
     * Creates new form CLMain
     */
    public static String tk; 
    public static String mk;
    public static int sotien;
    public static String sotienrut;
    public ATMInteface rmt;
    public CLMain() {
        initComponents( );
        setIconImage(new ImageIcon(getClass().getResource("bank.jpg")).getImage());
            this.getContentPane().setBackground(Color.decode("#C8E2B1"));
         loadata();
            
            jlb.setText("<html><font color='red'>Thoát</font></html>");
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbtentk = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbsosu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Thông tin tài khoản");

        jLabel2.setText("Tài khoản:");

        lbtentk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtentk.setForeground(new java.awt.Color(255, 0, 0));
        lbtentk.setText("./");

        jLabel3.setText("Số dư:");

        lbsosu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsosu.setForeground(new java.awt.Color(51, 0, 255));
        lbsosu.setText("./");

        jButton1.setText("Rút tiền");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlb.setText("Thoát");
        jlb.setAutoscrolls(true);
        jlb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlbMouseMoved(evt);
            }
        });
        jlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbMouseExited(evt);
            }
        });

        jButton2.setText("Chuyển Tiền");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbsosu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbtentk, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbtentk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbsosu))
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(72, 72, 72))
        );

        jlb.getAccessibleContext().setAccessibleName("Thoát");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void conectsv()
    {
        try {
            String host ="rmi://localhost:1099/severatm";
            LocateRegistry.getRegistry(host);
            try {
                rmt =(ATMInteface)Naming.lookup(host);
            } catch (NotBoundException ex) {
                Logger.getLogger(ClClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ClClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void loadata()
    {
       CLDangNhap lg = new CLDangNhap();
      
        try {
            conectsv();
           // loadtennd
             String a=(lg.taikhoan);
             String nd = rmt.getname(a);
            lbtentk.setText(nd);
            String mn= rmt.getmoney(a);
            lbsosu.setText(mn + " $");
            sotienrut =mn;
           // JOptionPane.showMessageDialog(null, sotienrut);
        } catch (Exception e) {
        }
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            CLRut clr = new CLRut();
            this.hide();
            clr.show();
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CLCTien ct= new CLCTien();
        ct.show();
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMouseClicked
        CLDangNhap CL= new CLDangNhap();
        CL.show();
        this.hide();
                
    }//GEN-LAST:event_jlbMouseClicked

    private void jlbMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMouseMoved
      jlb.setText("<html><font color='blue'><b><u>Thoát</u></b></font></html>");
    }//GEN-LAST:event_jlbMouseMoved

    private void jlbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMouseExited
         jlb.setText("<html><font color='red'>Thoát</font></html>");
    }//GEN-LAST:event_jlbMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
          
        java.awt.EventQueue.invokeLater(new Runnable() {
         //     load();
            public void run() {
                new CLMain().setVisible(true);
              ////  CLDangNhap LG= new CLDangNhap();
                //lbtentk.setText(LG.taikhoan);
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlb;
    public javax.swing.JLabel lbsosu;
    public javax.swing.JLabel lbtentk;
    // End of variables declaration//GEN-END:variables
}
