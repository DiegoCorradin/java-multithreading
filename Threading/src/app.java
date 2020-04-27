/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Utente
 */
public class app {
    
    public static void main(String[] args) throws Exception {
        Connection.getInstance().connect();
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for(int i = 0; i < 200; i++){
            executor.submit(new Runnable(){
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }  
}
