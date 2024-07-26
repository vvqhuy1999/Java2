/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6;

/**
 *
 * @author minhdiep
 */
public class EvenThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
              if (i % 2 == 0) {
                System.out.print(" " + i);
                try {
                    Thread.sleep(15);
                } catch (Exception e) {
                    System.out.print("Lỗi!!!");
                }
            }
        }
    }
}
