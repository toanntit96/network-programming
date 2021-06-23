/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Cold
 */
public class ClassInterface extends UnicastRemoteObject implements ATMInteface{
    ClassInterface() throws RemoteException{
    super();
    }
      public boolean ktdn(String a,String b)
      {
         ClassConnect c = new ClassConnect();
      if(c.checkuser(a, b))
          return true;
      return false;
 
      }
    public String getname(String a)
      {
          
        ClassConnect c = new ClassConnect();
        String d = c.loadtennd(a);
        return d;
      }     
    public String getmoney(String a) 
      {
        ClassConnect c = new ClassConnect();
        String d = c.loadtien(a);
        return d;
      }
    public boolean ruttien(String a, String h)
      {
        ClassConnect c = new ClassConnect();
       if(c.updateDB(a,h))
        return true;
       return false;
          
      }
    public boolean chuyentien(String ng,String nn,String st)
    {
        ClassConnect c = new ClassConnect();
                      if(c.chuyentien(ng, nn, st))
                          return true;
                      else
                          return false;
                   
    }
   
}
