import ADTPackage.QueuePackage.*;
import ADTPackage.StackPackage.*;
import ADTPackage.VertexPackage.VertexInterface;

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
            for(int i = 0; i < n; i++)
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
    
    public boolean addVertex(T vertex)
    {
        labels[index] = vertex;
        index++;
        return true; //will fix this in a bit
    }

    public void addEdge(int source, int target)
    {
        adjMatrix[source][target] = true;
        adjList.get(source).add(target);
       
    }

    @Override
    public boolean hasEdge(int begin, int end) {
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

   public QueueInterface<T> getBreadthFirstTraversal(int origin)
    {
        QueueInterface<T> traversalOrder + new LinkedQueue<>();
        QueueInterface<Integer> vertexQueue = new LinkedQueue<>();

        int visitVertex = origin;
        int[] visitedNeighbors = new int[numVertices + 1];
        int visitVertex = 0;
        visitVertex++;

        while(!vertexQueue.isEmpty())
        {
            int frontVertex = vertexQueue.dequeue();
            int[] vertexNeighbors = neighbors(frontVertex);

            int index = 0;
            boolean neighborsVisited = false;

            if(vertexNeighbors != null)
            {
                for(vertexNeighbors[index] == visitedNeighbors[i])
                {
                    if(vertexNeighbors[index] == visitedNeighbors[i])
                    {
                        index++;
                    }
                    if(index == vertexNeighbors.length)
                    {
                        neighborsVisited = true;
                        i = visitIndex;
                    }
                }
            }

            if(!neighborsVisited && vertexNeighbors != null)
            {
                for(int i = index; i < vertexNeighbors.length; i++)
                {
                    visitVertex = vertexNeighbors;
                    boolean isAlreadyVisited = false;

                    for(int k = 0; k < visitedNeighbors.length; k++)
                    {
                        if(visitVertex == visitedNeighbors[k])
                        {
                            isAlreadyVisited = true;
                            k = visitedNeighbors.length;
                        }
                    }
                    if(!isAlreadyVisited)
                    {
                        traversalOrder.enqueue(getLabel(visitVertex));
                        vertexQueue.enqueue(visitVertex);
                        visitedNeighbors[visitVertex] = visitVertex;
                        visitIndex++;
                    }
                }
            }
        }
        return traversalOrder;
    }

    public QueueInterface<T> getDepthFirstTraversal(int origin) {
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();
        int visitVertex = origin;
        int[] visitedNeighbors = new int[numVertices + 1];
        int visitIndex = 0;

        traversalOrder.enqueue(labels[origin]);
        vertexStack.push(origin);
        visitedNeighbors[visitIndex] = origin;
        visitIndex++;

        while(!vertexStack.isEmpty())
        {
            int topVertex = vertexStack.peek();
            int[] vertexNeighbors = neighbors(topVertex);

            int index = 0;
            boolean neighborsVisited = false;

            if(vertexNeighbors != null)
            {
                for(int i = 0; i < visitIndex; i++)
                {
                    if(vertexNeighbors[index] == visitedNeighbors[i])
                    {
                        index++;
                    }

                    if(index == vertexNeighbors.length)
                    {
                        neighborsVisited = true;
                        i = visitIndex;
                    }
                }

            }

            if(!neighborsVisited && vertexNeighbors != null)
            {
                visitVertex = vertexNeighbors[index];
                traversalOrder.enqueue(getLabel(visitVertex));
                vertexStack.push(visitVertex);

                visitedNeighbors[visitIndex] = visitVertex;
                visitIndex++;
            }
            else
            {
                vertexStack.pop();
            }
        }

        return traversalOrder;
    }

}
