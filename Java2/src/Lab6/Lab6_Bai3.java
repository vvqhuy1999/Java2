/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab6;

/**
 *
 * @author minhdiep
 */
public class Lab6_Bai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OddThread ot = new OddThread();
        EvenThread et = new EvenThread();
        Thread thread1 = new Thread(ot);
        Thread thread2 = new Thread(et);
        thread1.start();
        try {
            thread1.join();
        } catch (Exception e) {
        }
        
        thread2.start();
    }

}
