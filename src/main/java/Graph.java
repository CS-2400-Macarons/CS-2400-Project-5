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
        return null;
    }

    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        return null;
    }

    @Override
    public StackInterface<T> getTopologicalOrder() {
        return null;
    }

    @Override
    public int getShortestPath(T begin, T end, StackInterface<T> path) {
        return 0;
    }

    @Override
    public double getCheapestPath(T begin, T end, StackInterface<T> path) {
        return 0;
    }
}