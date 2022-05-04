import ADTPackage.QueuePackage.*;
import ADTPackage.StackPackage.*;
import java.util.ArrayList;

public class Graph<T> implements GraphInterface<T>
{
    private boolean adjMatrix[][];
    private ArrayList<ArrayList<Integer>> adjList;
    private T[] labels;
    private int numVertices;
    private int index = 0;
    

    public Graph(int n)
    {
        adjMatrix = new boolean[n][n];
        adjList = new ArrayList<ArrayList<Integer>>(n);
            for(int i = 0; i < num; i++)
                adjList.add(new ArrayList<Integer>());
        labels = (T[]) new Object[n];        
        this.numVertices = n;
    }

    public int[] neighbors(int vertex)
    {
        int i;
        int count = 0;
        int[] answer;

        for(i = 0; i < labels.length; i++)
        {
            if(adjMatrix[vertex][i])
            {
                count++;
            }
        }

        if(count == 0)
        {
            return null;
        }

        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++)
        {
            if(adjMatrix[vertex][i])
            {
                answer[count++] = i;
            }
        }
        return answer;
    }

    // graph interface methods below

    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    public void setLabel(int vertex, T newLabel)
    {
        labels[vertex] = newLabel;
    }

    public int size()
    {
        return numVertices;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        return false;
    }
    
    public void addVertex(T vertex)
    {
        labels[index] = vertex;
        index++;
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return false;
    }

    public void addEdge(int source, int target)
    {
        adjMatrix[source][target] = true;
        adjList.get(source).add(target);
       
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        return false;
    }
    
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public int getNumberOfVertices() {
        return numVertices;
    }

    @Override
    public int getNumberOfEdges() {
        int edges = 0;

        return 0;
    }

    @Override
    public void clear() {

    }

    // extra methods below
    
    //print the adjacency Matrix
    public String printAdjMatrix() {
        
       System.out.println("Adjacency Matrix: ");
       System.out.print("  ");
       for(int i = 0; i < numVertices; i++)
       {
           System.out.print(labels[i] + " ");
       }
       
        for (int i = 0; i < numVertices; i++) 
        {
            System.out.print("\n");
            System.out.print(labels[i] + " ");
            
          for (int j = 0; j < numVertices; j++) 
          {
              if(adjMatrix[i][j] == true)
              {
                  System.out.print("T ");
              }

              else
               System.out.print("F ");
            
            }      

        }
       return "\n";
        
      }

    //Print the adjacency list
    public String printAdjList()
    {
        System.out.println("\nAdjacency List: ");
        for(int i = 0; i < adjList.size(); i++)
        {
        
            System.out.print("\nVertex: " + labels[i] + ":");

            for(int j = 0; j < adjList.get(i).size(); j++)
            {
                System.out.print(" -> " + labels[adjList.get(i).get(j)]);
            }
        }
        return "\n";
    }

    public QueueInterface<T> getBreadthFirstTraversal(int origin) {
        return null;
    }

    public QueueInterface<T> getDepthFirstTraversal(int origin) {
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();
        int visitVertex = origin;

        // Mark originVertex as visited
        if(!adjMatrix[origin][origin])
        {
            return null;
        }
        traversalOrder.enqueue(labels[origin]);

        vertexStack.push(origin);

        while(!vertexStack.isEmpty())
        {
            int topVertex = vertexStack.peek();
            int[] vertexNeighbors = neighbors(topVertex);
            if(vertexNeighbors != null)
            {
                visitVertex = vertexNeighbors[0]; // visit first neighbor
                traversalOrder.enqueue(getLabel(visitVertex));
                vertexStack.push(visitVertex);
            }
            else
            {
                vertexStack.pop();
            }
        }

        return traversalOrder;
    }

}
