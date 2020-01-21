/**
 * This package defines an interface for graphs (in {@link graph.Graph}).  An implementation, using adjacency lists
 * (implemented using {@link java.util.Hashtable}s) is provided in {@link graph.AdjacencyGraph}.
 *
 * An interface for traversing graphs (as a subclass of the {@link graph.Graph} interface) is provided in
 * {@link graph.Traversal}.  Since this is a subclass of {@link graph.Graph}, a {@link graph.Traversal} object
 * will also be a {@link graph.Graph} object.  I.e., a {@link graph.Traversal} object does <i>not</i> need to
 * be provided with a graph to traverse, the traversal object is <i>itself</i> the graph that must be traversed.
 *
 * No implementations of {@link graph.Traversal} is provided.  These are left as an exercise.
 */
package graph;