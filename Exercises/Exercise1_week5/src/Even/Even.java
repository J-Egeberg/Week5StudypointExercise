/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Even;

/**
 *
 * @author Oakberg
 */
class main {
    public static void main(String[] args) {
        Even e = new Even();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1e8; i++) {
                double a = e.next();
                if (e.isEven(a)) {
                    System.out.println("t1, Even");
                } else {
                    System.out.println("t1, Odd");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1e8; i++) {
                double a = e.next();
                if (e.isEven(a)) {
                    System.out.println("t2, Even");
                } else {
                    System.out.println("t2, Odd");
                }
            }
        });
        t2.start();
    }
}

class Even {

    private int n = 0;

    public int next() {
        n++;
        n++;
        return n;
    }

    public synchronized boolean isEven(double value) {
        if (value % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

// ANSWER FOR A:
/**
 * Yes we are able to provoke the expected "ODD". Depending on the power of the PC,
 * we can adjust the number of iterations. Casper's mac can handle more iterations
 * before even becomes odd with volatile on the int n in the Even class, than
 * Danny's for example (Mac > Windows)
 *
 * ITS OVER 9000!!!!!
 */
// ANSWER FOR B:
/**
 *	Depending on the CPU on the machine, we can raise the level of iterations.
 *  A weaker PC will give more errors, if we raise the iterations. Likewise a stronger
 *  PC will be able to handle a bigger amount of iterations - atleast that is in our case.
 */
// ANSWER FOR C:
/**
 * We added the "synchronized" - in our isEven method and thus we got the syncronized
 * output. It will change from even to odd everytime you run the program.
 */
// ANSWER FOR D:
/**
 *
 */
