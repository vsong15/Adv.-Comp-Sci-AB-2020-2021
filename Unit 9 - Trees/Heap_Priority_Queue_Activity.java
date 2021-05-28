import java.util.PriorityQueue;
public class Heap_Priority_Queue_Activity{
   public static void main(String[]args){
      PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
      pq1.add(12);
      pq1.add(3);
      pq1.add(4);
      pq1.add(7);
      pq1.add(1);
      pq1.add(6);
      pq1.add(10);
      pq1.add(2);
      
      while(pq1.size() != 0){
         System.out.println(pq1.poll());
      }
   }
}