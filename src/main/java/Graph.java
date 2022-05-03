import ADTPackage.QueuePackage.*;
import ADTPackage.StackPackage.*;

public class Graph<T> implements GraphInterface<T>
{
    private boolean[][] edges;
    private T[] labels;

    public Graph(int n)
    {
        edges = new boolean[n][n];
        labels = (T[]) new Object[n];
    }

    public int[] neighbors(int vertex)
    {
        int i;
        int count = 0;
        int[] answer;

        for(i = 0; i < labels.length; i++)
        {
            if(edges[vertex][i])
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
            if(edges[vertex][i])
            {
                answer[count++] = i;
            }
        }
        return answer;
    }

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
        return labels.length;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return false;
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getNumberOfVertices() {
        return 0;
    }

    @Override
    public int getNumberOfEdges() {
        return 0;
    }

    @Override
    public void clear() {

    }

    public QueueInterface<T> getBreadthFirstTraversal(int origin) {
        return null;
    }

    public QueueInterface<T> getDepthFirstTraversal(int origin) {
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();
        int visitVertex = origin;

        // Mark originVertex as visited
        if(!edges[origin][origin])
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