package GraphPackage;

import ADTPackage.QueuePackage.QueueInterface;

/**
 * Tests adjacency matric and list representation and breadth-first and depth-first implementation
 */
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
        g.setLabel(0,"A");
        g.setLabel(1, "B");
        g.setLabel(2, "C");
        g.setLabel(3,"D");
        g.setLabel(4, "E");
        g.setLabel(5, "F");
        g.setLabel(6, "G");
        g.setLabel(7, "H");
        g.setLabel(8, "I");
    
        g.printAdjMatrix();
        g.printAdjList();

        // Testing depth-first traversal
        QueueInterface depth = g.getDepthFirstTraversal(0);

        System.out.println("\n\nDepth-First Traversal: ");

        for(int i = 0; i < g.getNumberOfVertices(); i++)
        {
            System.out.print(depth.dequeue());
        }

        // Testing breadth-first traversal
        QueueInterface breadth = g.getBreadthFirstTraversal(0);

        System.out.println("\n\nBreadth-First Traversal: ");

        for(int i = 0; i < g.getNumberOfVertices(); i++)
        {
            System.out.print(breadth.dequeue());
        }

    }
    
}
