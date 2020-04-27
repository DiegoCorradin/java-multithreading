
import java.util.Random;





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
                Random random = new Random();
                
                for (int i = 0; i < 1e8; i++) {
                    if(Thread.currentThread().isInterrupted()) { //verifica se il thread attuale è stato interrotto
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }    
        });
        t1.start();
        Thread.sleep(500);
        
        t1.interrupt(); //applica un flag il quale dice che un thread è stato interrotto, non lo stoppa
        t1.join();
        
        System.out.println("Finished.");
    }
}
