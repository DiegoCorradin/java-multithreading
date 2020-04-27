
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
public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    public void firstThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Account.transfer(acc1, acc2, random.nextInt(100));
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Account.transfer(acc2, acc1, random.nextInt(100));
        }
    }
    

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: : " + (acc1.getBalance() + acc2.getBalance()));
    }
}
