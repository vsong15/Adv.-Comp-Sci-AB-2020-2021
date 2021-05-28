
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BankQueue{

   
   public static void main(String[] args) { 
   
      double cust_rate_ppl_per_minute = 1;
      double avg_proc_time_seconds = 90;
      int num_tellers = 2;
      boolean verbose_mode = false;
      int pause_time_ms = 1500; 
            
      runBankQueue(cust_rate_ppl_per_minute,avg_proc_time_seconds,num_tellers,verbose_mode,pause_time_ms);      
   
   }


   public static void runBankQueue(double cust_arr_rate_people_per_minute, double avg_proc_time_seconds, int number_of_tellers, boolean verbose_mode, int pause_time_ms) {
   
      // Customer Queue / variables
      Queue<Integer> cust_q = new LinkedList<>();  // The integer will be the customer number
      int new_customer_id = 1;
      int temp_cust_id;
      
      // Bank teller array
      double[] tellers = new double[number_of_tellers];  // stores teller time until done (seconds)
      int teller_id = -1;
      
      // Other Constants
      int MAX_TIME_SECONDS = 500;  
      int MAX_QUEUE_SIZE = 10;
                 
      // Time-related variables 
      double current_time_seconds = 0;  // stores the time 
      double time_increment_seconds = 15; // delta t
      
      // Run the simulation
      while(current_time_seconds < MAX_TIME_SECONDS){
      
         // print the status of the queue and and the tellers for this update and the current time
         System.out.println();
         System.out.println(" Time (s):  " + current_time_seconds);
         if(verbose_mode){
            System.out.println(" Tellers: " + printTellerStatus(tellers));
         }
      
         // update the status of the tellers - decrement the remaining arrival time by the time increment
         for(int i = 0; i < tellers.length; i++){
            if(tellers[i] > 0){
               if(tellers[i] >= time_increment_seconds){
                  tellers[i] = tellers[i] - time_increment_seconds;
               } else {
                  tellers[i] = 0;
               }
            }
         }
      
         // add a customer to the queue (random - based on arrival rate)
         if(addCustomer(cust_arr_rate_people_per_minute,time_increment_seconds)){
            System.out.println(" Customer " + new_customer_id + " arrived");
            cust_q.add(new_customer_id);
            System.out.println(" Customer Queue: " + cust_q);
            new_customer_id++;
         }       
         
             
         // Check the queue - if not empty, process a customer
         if(cust_q.peek() != null){
         
            // Check if a teller is available
            teller_id = tellerIsAvailable(tellers);
            if(teller_id != -1){
            
               // remove the customer at the front of the queue
               temp_cust_id = cust_q.remove();
               System.out.println(" Customer "  + temp_cust_id + " processed");
            
               // teller has a countdown to when they are available - random valued according to a distribution
               tellers[teller_id] = setTellerTimer(avg_proc_time_seconds);
                        
            }   
         }
      
         // Print an error if the max acceptable queue length has been exceeded
         if(cust_q.size() > MAX_QUEUE_SIZE){
            System.out.println("**** QUEUE SIZE EXCEEDED!!  Queue Size: " + cust_q.size() + " Max Allowable Size: " + MAX_QUEUE_SIZE);  
         }
      
         // update the time increment      
         current_time_seconds = current_time_seconds + time_increment_seconds;  
         
         // Pause the execution of the program
         try {
            Thread.sleep(pause_time_ms);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
               
      }   // END OF SIMULATION LOOP 
   
   
   }  // END OF RUNBANKQUEUE METHOD
   
   
   // Print the status of the bank teller array
   public static String printTellerStatus(double[] tellers){
      String output = "";
      output = output + "Remaing time [ ";
      for(int i = 0; i < tellers.length; i++){
         output = output + tellers[i] + "s ";      
      }
      output = output + "] ";
      return output;
   }
   
   // Check if a teller is available
   public static int tellerIsAvailable(double[] tellers){
      
      // Find an available teller
      for(int i = 0; i < tellers.length; i++){
         if(tellers[i] == 0){
            return i;
         }        
      }
      
      // Return -1 to indicate no available tellers
      return -1;
   }
   
   // Generate a randome timer for bank tellers
   public static double setTellerTimer(double avg_proc_time_seconds){
      Random r = new Random();
      double proctime;
      double mean = avg_proc_time_seconds;
      double std_dev = avg_proc_time_seconds*0.3;
      proctime = std_dev*(r.nextGaussian()) + mean;  
      return Math.round(proctime*10)/10;
   
   }

   // Decide whether to add a customer based on arrival rate and time increment
   public static boolean addCustomer(double cust_arr_rate_people_per_minute, double time_increment_seconds){
      
      int SEC_PER_MINUTE = 60;
      double prob_arrival = (cust_arr_rate_people_per_minute*time_increment_seconds)/SEC_PER_MINUTE;
      double r = Math.random();
      if(r >= prob_arrival){
         return true;
      } else {
         return false;
      }
   }
   

}