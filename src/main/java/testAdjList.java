import java.util.ArrayList;

public class testAdjList {
    //char[] labelVertex;

  // Add edge
  static void addEdge(ArrayList<ArrayList<Integer>> adjList, int source, int target) {
    adjList.get(source).add(target);
   
  }

  public static void main(String[] args) {

    int numVertex = 9;
     char[]labelVertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(numVertex);

    for (int i = 0; i < numVertex; i++)
      adjList.add(new ArrayList<Integer>());

    // Add edges
   
        addEdge(adjList,0, 1);
        addEdge(adjList, 0, 3);
        addEdge(adjList,0, 4);
        addEdge(adjList,1, 4);
        addEdge(adjList,2, 1);
        addEdge(adjList,3, 6);
        addEdge(adjList,4, 5);
        addEdge(adjList,4, 7);
        addEdge(adjList,5, 2);
        addEdge(adjList,5, 7);
        addEdge(adjList,6, 7);
        addEdge(adjList,7, 8);
        addEdge(adjList,8, 5);
    

    printGraph(adjList,labelVertex);
  }

  // Print the graph
  static void printGraph(ArrayList<ArrayList<Integer>> adjList, char[] labelVertex) {
    for (int i = 0; i < adjList.size(); i++) {
      System.out.print("\nVertex " + labelVertex[i] + ":");
      for (int j = 0; j < adjList.get(i).size(); j++) {
        System.out.print(" -> " + labelVertex[adjList.get(i).get(j)]);
      }
      System.out.println();
    }
  }
}
class testAdjList {
    
}
