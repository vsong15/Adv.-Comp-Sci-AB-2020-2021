public class IntegerGraphTest{
   public static void main(String[]args){
      IntegerGraph g = new IntegerGraph(3);
      g.addBiEdge(0,1);
      g.addEdge(1,2);
      g.addEdge(0,2);
      System.out.println(g.isConnected(0,2));
      System.out.println(g.isConnected(2,0));
   
   
      IntegerGraph g2 = new IntegerGraph(8);
   
      g2.addBiEdge(0,2);
      g2.addBiEdge(0,3);
      g2.addBiEdge(2,3);
      g2.addBiEdge(3,6);
      g2.addBiEdge(1,4);
      g2.addBiEdge(1,5);
      g2.addBiEdge(4,5);
      g2.addBiEdge(4,7);
      System.out.println(g2.isConnected(0,6));
      System.out.println(g2.isConnected(2,5));
   
   
   
   }
}