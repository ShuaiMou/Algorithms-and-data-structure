package algotithm.graph;

import java.util.LinkedList;

/**
 * this class is used to graph algorithms:
 *  1.DFS
 *  2.BFS
 *  3.topological sort
 * 	4. Warshall
 *  5. Floyd
 *  6. Prim
 *  7. Dijkstra. 
 *  
 * @author Saul
 * 2019-06-06
 *
 */
public class GraphAlgorithms {
	/**
	 * adjacency matrix
	 */
	private int[][] adjacencyMatrix;
	
	/**
	 * adjacency List
	 */
	private LinkedList<String>[] adjacencyList;
	
	/**
	 * vertices of the graph
	 */
	private String[] nodes;
	
	public GraphAlgorithms( int[][] adjacencyMatrix, String[] nodes ){
		this.adjacencyMatrix = adjacencyMatrix;
		this.nodes = nodes;
	}
	
	public GraphAlgorithms( LinkedList<String>[] adjacencyList, String[] nodes ){
		this.adjacencyList = adjacencyList;
		this.nodes = nodes;
	} 
	

	public void DFS(){
		
	}
	
	private void DFSExplore(){
	
	}
	
}
