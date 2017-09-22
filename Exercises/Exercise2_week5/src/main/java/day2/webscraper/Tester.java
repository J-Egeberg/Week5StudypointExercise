package day2.webscraper;

public class Tester{
  
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
    
    Long start = System.nanoTime();
    
    TagCounter tc1 = new TagCounter("http://www.fck.dk");
    tc1.start();
    tc1.run();
    tc1.join();
    TagCounter tc2= new TagCounter("http://www.google.com");
    tc2.start();
    tc2.run();
    tc2.join();
    TagCounter tc3= new TagCounter("http://politiken.dk/");
    tc3.start();
    tc3.run();
    tc3.join();
    
    
    Long end = System.nanoTime();
    
    
    //parallel execution
    Long start1 = System.nanoTime();
    
    TagCounter tc4 = new TagCounter("http://www.fck.dk");
    tc4.run();
                                                                     
    Long end1 = System.nanoTime();
    
    System.out.println("Time Sequential: "+(end-start));
    
    System.out.println("Time Sequential: "+(end1-start1));
    
    System.out.println("Title: "+tc1.getTitle());
    System.out.println("Div's: "+tc1.getDivCount());
    System.out.println("Body's: "+tc1.getBodyCount());         
    
    System.out.println("Title: "+tc2.getTitle());
    System.out.println("Div's: "+tc2.getDivCount());
    System.out.println("Body's: "+tc2.getBodyCount());   
    
    System.out.println("Title: "+tc3.getTitle());
    System.out.println("Div's: "+tc3.getDivCount());
    System.out.println("Body's: "+tc3.getBodyCount());         
  }

}
