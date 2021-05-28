import java.util.*;
public class WGraph
{
   // Private instance variables
   /* YOUR CODE HERE */
   private int vertices;
   private double matrix[][];
   
   // Constructor
   public WGraph(int n){
      /* YOUR CODE HERE */
      vertices = n;
      matrix = new double[n][n];
   }
   
   // Add a unidirectional weighted edge
   public void addEdge(int source, int destination, double weight){
      /* YOUR CODE HERE */
      matrix[source][destination] = weight;
   }
      
   // Add a bidirectional weighted edge
   public void addBiEdge(int source, int destination, double weight){
      /* YOUR CODE HERE */
      matrix[source][destination] = weight;
      matrix[destination][source] = weight;
   }
   
   // Compute the shortest path between the source and destination vertex
   public double shortestPath(int source, int destination){
      /* YOUR CODE HERE */
      boolean[] visited = new boolean[vertices];
      int [] distance = new int[vertices];
      int [] parent = new int [vertices];
      int infinity = Integer.MAX_VALUE;   
      parent[source] = -1;
      for (int i = 0; i < vertices; i++) {
         distance[i] = infinity;
      }
      distance[source] = 0;
      for (int i = 0; i < vertices; i++) {
         int u = getClosestAdjacentVertex(visited, distance);
         if(u != -1){
            visited[u] = true;
            for (int v = 0; v <vertices ; v++) {
               if(matrix[u][v] > 0){   
                  if(visited[v] == false && matrix[v][v] != infinity){   
                     int newDistance = (int)matrix[u][v] + distance[u];
                     if(newDistance < distance[v]){
                        distance[v] = newDistance;
                        parent[v] = u;
                     }
                  }
               }
            }
         }
      }
      printDijkstraAlgorithm(parent, distance, source, destination);
      return (double)(distance[destination]);
   }
   
   public int getClosestAdjacentVertex(boolean [] visited, int [] distance){
      int distanceFromSource = Integer.MAX_VALUE;
      int vertex = -1;
      for (int i = 0; i < vertices; i++) {
         if(visited[i] == false && distanceFromSource > distance[i]){
            distanceFromSource = distance[i];
            vertex = i;
         }
      }
      return vertex;
   }

   public void printDijkstraAlgorithm(int[] parent, int [] distance, int source, int destination){
      System.out.print(source + " -> " + destination + ": Distance = "+(double)distance[destination] + " Shortest Path: ");
      printShortestPath(parent, source, destination);
      System.out.println();
   }

   public void printShortestPath(int parent[], int source, int destination){
      if(parent[destination] == -1) {
         System.out.print(source + " ");
         return;
      }
      printShortestPath(parent, source, parent[destination]);
      System.out.print(destination + " ");
   }

   public static void main(String[] args) {
      WGraph g = new WGraph(5);
      g.addEdge(0,1,10.0);
      g.addEdge(0,4,100.0);
      g.addEdge(0,3,30.0);
      g.addEdge(1,2,50.0);
      g.addEdge(3,2,20.0);
      g.addEdge(2,4,10.0);
      g.addEdge(3,4,60.0);
      System.out.println(g.shortestPath(0,4)); 
   
      WGraph g2 = new WGraph(7);
      g2.addBiEdge(0,1,2.0);
      g2.addBiEdge(0,2,6.0);
      g2.addBiEdge(1,3,5.0);
      g2.addBiEdge(2,3,8.0);
      g2.addBiEdge(3,5,15.0);
      g2.addBiEdge(3,4,10.0);
      g2.addBiEdge(4,5,6.0);
      g2.addBiEdge(4,6,2.0);
      g2.addBiEdge(5,6,6.0);
      System.out.println(g2.shortestPath(0,5));  
   }
}