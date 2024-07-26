/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab6;

/**
 *
 * @author minhdiep
 */
public class Lab6_Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt);
        Thread thread2 = new Thread(mt);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }
    
}
