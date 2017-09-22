package day2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class RandomNumberProducer implements Runnable{

  public static final int MAX_NUMBERS_TO_PRODUCE = 100;
  public static final int MAX_RANDOM = 100;

  ArrayBlockingQueue<Integer> numbersProduced;

  public RandomNumberProducer(ArrayBlockingQueue<Integer> numbersProduced) {
    this.numbersProduced = numbersProduced;
  }
  
  @Override
  public void run() {
    throw new UnsupportedOperationException("You nedd to complete the run() method for this to work");
    //Todo: Produce MAX_NUMBERS_TO_PRODUCE of random numbers between 0 and MAX_RANDOM and
    //      place the numbers in numbersProduced
  }
  
  //By now, you should know how to produce random numbers, but if not, use/run this as a guide
  public static void main(String[] args) {

    for (int i = 0; i < MAX_NUMBERS_TO_PRODUCE; i++) {
      int random = (int) ((Math.random() * MAX_RANDOM+1));
      System.out.println(random);System.out.println(i);
    }
  }

  
  
}
