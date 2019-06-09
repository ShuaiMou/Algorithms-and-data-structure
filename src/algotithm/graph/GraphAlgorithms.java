package algotithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	//private LinkedList<String>[] adjacencyList;
	
	/**
	 * vertices of the graph
	 */
	private String[] nodes;
	
	/**
	 * used to know whether the node has been visited or not
	 */
	boolean[] markNode;
	
	/**
	 * use stack to store the elements visited by DFS or BFS.
	 */
	private Stack< String > dfs_bfsSequence = null;
	
	public GraphAlgorithms( int[][] adjacencyMatrix, String[] nodes ){
		this.adjacencyMatrix = adjacencyMatrix;
		this.nodes = nodes;
	}
	
	/*
	public GraphAlgorithms( LinkedList<String>[] adjacencyList, String[] nodes ){
		this.adjacencyList = adjacencyList;
		this.nodes = nodes;	
	} 
	*/
	
	private void initGraph(){
		this.markNode = new boolean[nodes.length];
		dfs_bfsSequence = new Stack<>();
	}

	/**
	 * depth first search
	 * visit one node push it to stack
	 * 
	 * @return the visit stack
	 */
	public Stack< String > DFS(){
		initGraph();
		for(int i = 0; i < nodes.length; i++){
			if ( !markNode[ i ] ) {
				DFSExplore( i );
			}
		}
		return dfs_bfsSequence;
	}
	
	private void DFSExplore(int index){
		markNode[ index ] = true;
		dfs_bfsSequence.push(nodes[ index ]);
		for (int i = 0; i < adjacencyMatrix[ index ].length; i++) {
			if (adjacencyMatrix[ index ][ i ] == 1 && !markNode[ i ]) {
				DFSExplore( i );
			}
		}
	}
	
	/**
	 * bread first search
	 * visit one node push it to stack
	 * 
	 * @return the visit stack
	 */
	public  Stack< String >  BFS(){
		initGraph();
		Queue<String> queue = new LinkedList<>();
		for(int i = 0; i < nodes.length; i++){
			if ( !markNode[ i ]) {
				queue.add(nodes[ i ]);
				markNode[ i ] = true; 
				dfs_bfsSequence.add(nodes[ i ]);
				BFSExplore(i, queue);
			}
		}
		return dfs_bfsSequence;
	}
	
	private void BFSExplore(int index, Queue<String> queue){
		queue.remove();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[ index ][ i ] == 1 && !markNode[ i ]) {
				queue.add(nodes[ i ]);
				dfs_bfsSequence.add(nodes[ i ]);
				markNode[ i ] = true;
			}
		}
		if( !queue.isEmpty() ) {
			int position = -1;
			String node = queue.peek();
			for (int i = 0; i < nodes.length; i++) {
				if (node.equals(nodes[ i ])) {
					position = i;
					break;
				}
			}
			BFSExplore(position, queue);
		}
	}
}
