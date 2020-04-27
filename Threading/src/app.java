



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utente
 */
public class app {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Starting.");
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                
            }    
        });
        t1.start();
        
        t1.join();
        
        System.out.println("Finished.");
    }
}
