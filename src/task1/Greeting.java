/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.Date;
/**
 *
 * @author Gerges_Hanna
 */
public class Greeting  implements Runnable{

    private final int daily=1000;
    private final int repeat=10;
    private String GreetingPtint;

    public Greeting(String GreetingPtint) {
        this.GreetingPtint = GreetingPtint;
    }
    
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < repeat; i++) {
                System.out.println(new Date()+" "+GreetingPtint);
                Thread.sleep(daily);
            }
        } catch (InterruptedException exception) {
            System.out.println(exception);
        }
       
    }
    
}
