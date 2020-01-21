package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DepthFirstSort<T> extends AdjacencyGraph<T> implements Traversal<T> {

    private ArrayDeque<T> backTrack = new ArrayDeque<T>(); // the to do list
    private List<T> traversal = new ArrayList<T>(); // the traversal

    @Override
    public List<T> traverse() throws GraphError {

        T node = getUnvisitedNode(); // get an unvisited node

        while (node != null) { // while there is at least one unvisited node
            backTrack.add(node);
            traverseBackTrack();
            node = getUnvisitedNode();
        }

        return traversal;
    }

    /**
     * Check if a node has been visited, or is due to be visited.
     * I.e. check if the node is
     * <ul>
     * <li> in the traversal, having actually been visited
     * <li> or in the to do list, and therefore scheduled to be visited
     * </ul>
     *
     * @return this node has been visited, or is scheduled to be visited
     */
    public boolean visited(T node) {

        return traversal.contains(node); // the node has been visited and is in the traversal
    }

    /**
     * Get the next "unvisited" node.  This method will actually also count nodes
     * that are scheduled to be visited (i.e. in the to do list) as visited.
     *
     * @return a node that has not yet been visited, and that is not yet scheduled to be visited, or return null if no such node exists
     */
    private T getUnvisitedNode() {

        for (T node : getNodes()) { // check all the nodes
            if (!visited(node)) { // if this node has not been "visited"
                return node; // then this is an unvisited node
            }
        }

        // checked all nodes, and there are no unvisited nodes
        return null; // so return null
    }

    private void traverseBackTrack() throws GraphError {

        while (backTrack.size() > 0) { // as long as there are still nodes in the to do list
            T node = backTrack.getLast();
            backTrack.remove();//remove node;
            visitNode(node); // and visit that node
        }
    }

    /**
     * Visit a node.
     *
     * @throws GraphError if node is not a node in the graph
     */
    private void visitNode(T node) throws GraphError {

        if (visited(node)) return; // if the node is already visited do nothing
        traversal.add(node); // add the node to the traversal

        for (T neighbour : getNeighbours(node)) { // for all this node's neighbours
            if (!visited(neighbour)) // if the neighbour hasn't been visited
                backTrack.add(neighbour); // add it to the end of the to do list
        }
    }
}
