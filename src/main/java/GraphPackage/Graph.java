package GraphPackage;

import ADTPackage.QueuePackage.*;
import ADTPackage.StackPackage.*;

import java.util.ArrayList;

/**
 The Graph Class with Adjacency Matrix and Adjacency representations,
 including breadth-first and depth-first traversal methods.
 */
public class Graph<T> implements GraphInterface<T>
{
    private boolean adjMatrix[][];
    private ArrayList<ArrayList<Integer>> adjList;
    private T[] labels;
    private int numVertices;

    /** Creates an adjacency matrix and list for the graph
     * @param n The number of vertices in the graph.
     */
    public Graph(int n)
    {
        adjMatrix = new boolean[n][n];
        adjList = new ArrayList<ArrayList<Integer>>(n);
            for(int i = 0; i < n; i++)
                adjList.add(new ArrayList<Integer>());
        labels = (T[]) new Object[n];        
        this.numVertices = n;
    }

    /** Returns the neighboring vertices in an array
     * @param vertex Selected vertex
     * @return An integer array of vertices that neighbors the selected vertex
     */
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

    /** Returns label of vertex
     * @return Label of vertex
     */
    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    /** Sets the label of the vertex
     * @param vertex The selected vertex of the graph
     * @param newLabel The label assigned to the vertex
     */
    public void setLabel(int vertex, T newLabel)
    {
        labels[vertex] = newLabel;
    }

    /** Returns number of vertices
     * @return The number of vertices of the graph
     */
    public int size()
    {
        return numVertices;
    }

    /** Adds an unweighted edge between two given distinct vertices
     that are currently in this graph. The desired edge must not
     already be in the graph. In a directed graph, the edge points
     toward the second vertex given.
     @param source An object that labels the origin vertex of the edge.
     @param target    An object, distinct from begin, that labels the end
     vertex of the edge. */
    public void addEdge(int source, int target)
    {
        adjMatrix[source][target] = true;
        adjList.get(source).add(target);
    }

    /** Sees whether an edge exists between two given vertices.
     @param begin  An object that labels the origin vertex of the edge.
     @param end    An object that labels the end vertex of the edge.
     @return  True if an edge exists. */
    @Override
    public boolean hasEdge(int begin, int end) {
        return adjMatrix[begin][end];
    }

    /** Sees whether this graph is empty.
     @return  True if the graph is empty. */
    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    /** Gets the number of vertices in this graph.
     @return  The number of vertices in the graph. */
    public int getNumberOfVertices() {
        return numVertices;
    }


    /** Returns the adjacency matrix in a to-be printed String
     * @return Adjacency matrix
     */
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

    /** Returns the adjacency list in a to-be printed String
     * @return Adjacency list
     */
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

    /** Performs a breadth-first traversal of this graph.
     @param origin  An integer that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
   public QueueInterface<T> getBreadthFirstTraversal(int origin)
    {
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<Integer> vertexQueue = new LinkedQueue<>();

        int visitVertex = origin;
        int[] visitedNeighbors = new int[numVertices + 1];
        int visitIndex = 0;

        traversalOrder.enqueue(labels[origin]);
        vertexQueue.enqueue(origin);
        visitedNeighbors[visitIndex] = origin;
        visitIndex++;

        while(!vertexQueue.isEmpty())
        {
            int frontVertex = vertexQueue.dequeue();
            int[] vertexNeighbors = neighbors(frontVertex);

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
                for(int i = index; i < vertexNeighbors.length; i++)
                {
                    visitVertex = vertexNeighbors[i];
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

    /** Performs a depth-first traversal of this graph.
     @param origin  An integer that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
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
