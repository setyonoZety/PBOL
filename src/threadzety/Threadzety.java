/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadzety;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author asus
 */
class Proses implements Runnable{
    private int id;
    
    public Proses(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Mulai Thread :"+id);
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Selesai Thread :"+id);
        
        }
    }
        
public class Threadzety {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ExecutorService service = Executors.newFixedThreadPool(2); 
      
      for (int i =1; i<100; i=i+2){
      service.submit(new Proses(i));
    }
    service.shutdown();
 
        System.out.println("Semuanya sudah dimulai");
        
        try{
            service.awaitTermination(1, TimeUnit.DAYS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("SEMUANYA SELESAI");
    
    }
    
}
