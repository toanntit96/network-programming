/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.rmi.*;
/**
 *
 * @author Cold
 */
public interface ATMInteface extends Remote {
    public boolean ktdn(String a,String b) throws RemoteException;
    public String getname(String a) throws RemoteException;
    public String getmoney(String a) throws RemoteException;
    public boolean ruttien(String a,String v) throws RemoteException;
    public boolean chuyentien(String ng,String nn,String st) throws RemoteException;
  
}
