/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cold
 */

public class ClClass {
    ATMInteface rmt;
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
    }

