/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.Semaphore;
/**
 *
 * @author Utente
 */
public class app {
    
    public static void main(String[] args) throws Exception {
        Semaphore sem = new Semaphore(1);
        
        sem.release();
        sem.acquire();
        
        System.out.println("Available permits: " + sem.availablePermits());
    }
    
}
