/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1_week5;

import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;

/**
 *
 * @author Oakberg
 */
public class Threads {

   public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10E+6; i++) {
                System.out.println("t1: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("t2: " + i);
            }
        });

        Thread t3 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            try {
                int i = 10;
                while (System.currentTimeMillis() < startTime + 10000) {
                    System.out.println("t3:" + i);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
