import ADTPackage.QueuePackage.QueueInterface;
import ADTPackage.StackPackage.StackInterface;

public class Graph<T> implements GraphInterface<T>
{
    private boolean[][] edges;

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

    @Override
    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        // Use Queue
        return null;
    }

    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        // Use Stack
        QueueInterface<String> traversalOrder;
        return null;

    }

}