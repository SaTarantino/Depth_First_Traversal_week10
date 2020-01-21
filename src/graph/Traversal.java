package graph;

import java.util.List;

/**
 * Defines the interface for graph traversals.
 *
 * You should not modify this code.  Instead, implement traversal(s) as new classes.
 * 
 * @author Hugh Osborne
 * @version November 2019
 */
public interface Traversal<T> extends Graph<T>
{
    /**
     * Perform a traversal of the graph, and return the nodes in the order in which they are visited.
     *
     * @return a traversal of the graph in which each node is visited exactly once.
     * @throws GraphError if non-existent nodes or edges are accessed during the attempt to build the traversal, or if
     *          the traversal tries to make changes to the graph (which it shouldn't do in any case) that attempt to
     *          either add nodes or edges to the graph that are already in the graph, or delete nodes or edges that do
     *          not exist in the graph.
     */
    public List<T> traverse() throws GraphError;
}