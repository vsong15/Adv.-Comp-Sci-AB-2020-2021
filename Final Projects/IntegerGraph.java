import java.util.*;

public class IntegerGraph
{

   // Private instance variables
   /* YOUR CODE HERE */
   private int vertices;
   private ArrayList<LinkedList<Integer>> adj_list = new ArrayList<LinkedList<Integer>>();
   private boolean [] visited_vertices;
   
   // Constructor
   public IntegerGraph(int n){
   
     /* YOUR CODE HERE */
      vertices = n;
      for(int i = 0; i < n; i++){
         adj_list.add(new LinkedList<Integer>());
      }
      visited_vertices = new boolean[n];
      for(int i = 0; i < n; i++){
         visited_vertices[i] = false;
      }
   }
   
   // addEdge Method
   public void addEdge(int source, int destination){
   
      /* YOUR CODE HERE */
      adj_list.get(source).add(destination);
   
   }  

   // addBiEdge Method
   public void addBiEdge(int source, int destination){
   
      /* YOUR CODE HERE */
      adj_list.get(source).add(destination);
      adj_list.get(destination).add(source);
   
   }
   
   // Check to see if the destination vertex can be reached
   // from the source vertex
   public boolean isConnected(int source, int destination){
   
      /* YOUR CODE HERE */
      return Depth_First_Search(source, destination, adj_list.get(source), visited_vertices);
   }

   public boolean Depth_First_Search(int source, int destination, LinkedList<Integer> adjacent_vertices, boolean [] visited){
      if(source == destination)
         return true;
      if(!visited[source])
         visited[source] = true;
      for(int i = 0; i < adjacent_vertices.size(); i++){
         if(!visited[adjacent_vertices.get(i)]){
            if(Depth_First_Search(adjacent_vertices.get(i), destination, adj_list.get(adjacent_vertices.get(i)), visited))
               return true;
         }
      }
      return false;
   }
}