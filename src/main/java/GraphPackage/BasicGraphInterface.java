package GraphPackage;

/**
 An interface of methods providing basic operations for directed
 and undirected graphs that are either weighted or unweighted.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public interface BasicGraphInterface<T>
{
    /** Adds an unweighted edge between two given distinct vertices
     that are currently in this graph. The desired edge must not
     already be in the graph. In a directed graph, the edge points
     toward the second vertex given.
     @param begin  An object that labels the origin vertex of the edge.
     @param end    An object, distinct from begin, that labels the end
     vertex of the edge. */
    public void addEdge(int begin, int end);

    /** Sees whether an edge exists between two given vertices.
     @param begin  An object that labels the origin vertex of the edge.
     @param end    An object that labels the end vertex of the edge.
     @return  True if an edge exists. */
    public boolean hasEdge(int begin, int end);

    /** Sees whether this graph is empty.
     @return  True if the graph is empty. */
    public boolean isEmpty();

    /** Gets the number of vertices in this graph.
     @return  The number of vertices in the graph. */

    /** Returns label of the selected vertex
     * @param vertex Selected vertex
     * @return Label of vertex
     */
    public T getLabel(int vertex);

    /** Sets the label of the vertex
     * @param vertex The selected vertex of the graph
     * @param label The label assigned to the vertex
     */
    public void setLabel(int vertex, T label);

    /** Gets the number of vertices in this graph.
     @return  The number of vertices in the graph. */
    public int getNumberOfVertices();

} // end GraphPackage.BasicGraphInterface
