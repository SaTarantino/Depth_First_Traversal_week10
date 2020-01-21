import graph.DepthFirstSort;
import graph.GraphError;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepthFirstSortTraversalTest<T> {

    DepthFirstSort depthFirstSort = new DepthFirstSort();

    public DepthFirstSort<T> addNodesToGraph(int[] array) throws GraphError {
        for (int i = 0; i < array.length; i++) {
            depthFirstSort.add(i);
        }
        return depthFirstSort;
    }

    int[] array = new int[]{0, 1, 2, 3, 4, 5};

    void createNodes() throws GraphError {
        addNodesToGraph(array);
        depthFirstSort.add(0, 1);
        depthFirstSort.add(0, 3);
        depthFirstSort.add(1, 3);
        depthFirstSort.add(3, 5);
        depthFirstSort.add(5, 2);
        depthFirstSort.add(4, 5);
        depthFirstSort.add(0, 4);
        depthFirstSort.add(4, 0);
    }

    /**
     * add Method test
     * @throws GraphError
     */
    @Test
    void addMethod() throws GraphError {
        depthFirstSort.add(42);
        assertTrue( depthFirstSort.contains(42));
    }


    /**
     * vidited node method test
     * @throws GraphError
     */
    @Test
    void maxVisitedNodeTest() throws GraphError {
        createNodes();
        depthFirstSort.traverse();
        assertTrue(depthFirstSort.visited(5));
    }

    /**
     * travers method test
     * @throws GraphError
     */
    @Test
    void traversTest() throws GraphError {
        createNodes();
        List<Integer> traverse = depthFirstSort.traverse();
        List<Integer> traverseList = Arrays.asList(0, 4, 5, 2, 1, 3);
        assertEquals(traverseList, traverse);
    }

    @Test
    void traversGraphTest() throws GraphError {
        createNodes();
        List<Integer> traverse = depthFirstSort.traverse();
        assertTrue(traverse.contains(0));
        assertTrue(traverse.contains(1));
        assertTrue(traverse.contains(2));
        assertTrue(traverse.contains(3));
        assertTrue(traverse.contains(4));
        assertTrue(traverse.contains(5));
    }

    @Test
    void sizeTest() throws GraphError {
        createNodes();
        List<Integer> traverse = depthFirstSort.traverse();
        assertEquals(traverse.size(), 6);
    }
}
