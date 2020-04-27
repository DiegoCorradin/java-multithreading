
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utente
 */
public class Connection {
    
    private static Connection instance = new Connection();
    
    private Semaphore sem = new Semaphore(10, true); //con true: il thread a cui è associato sarà il primo a ricevere il permit quando sarà accessibile
    
    private int connections = 0;
    
    private Connection() {
        
    }
    
    public static Connection getInstance() {
        return instance;
    }
    
    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        try {
            doConnect();
        } finally {
            sem.release();
        }
    }
    
    public void doConnect() {
        
        synchronized (this) {
            connections++;
            System.out.println("Current connections: "+ connections);
        }
        
        try {
            Thread.sleep(2000);
                } catch (InterruptedException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized (this) {
            connections--;
        }

    }
}
