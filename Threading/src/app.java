
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
public class app {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<?> future = executor.submit(new Callable<Void>(){
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);
                
                if(duration > 2000) {
                    throw new IOException("Sleeping for too long");
                }
                
                System.out.println("Starting..");
                
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                System.out.println("Finished..");
                
                return null;
            }
            
        });
        
        executor.shutdown();
        
        try {
            System.out.println("The result is: " + future.get());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            IOException e = (IOException) ex.getCause();
            System.out.println(e.getMessage());
        }
        
        
    }
}
