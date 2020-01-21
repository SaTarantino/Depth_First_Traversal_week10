package graph;
/**
 * Superclass for graph specific errors
 * 
 * @author Hugh Osborne
 * @version December 2019
 */
public class GraphError extends Exception
{
    public GraphError() {
        super("Unspecified graph error");
    }
    
    public GraphError(String message) {
        super(message);
    }
}