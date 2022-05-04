import java.util.ArrayList;
import java.util.*;
public class testGraph{

    

   
    public static void main(String[] args)

    {
        //Create and graph and representing as an adjacency matrix
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(2, 1);
        g.addEdge(3, 6);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 2);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 5);
        
        //Label the vertex 
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");
        g.addVertex("H");
        g.addVertex("I");
    
        g.printAdjMatrix();
        g.printAdjList();
         
    }
    
}
