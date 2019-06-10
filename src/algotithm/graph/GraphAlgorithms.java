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
	
	/**
	 * for topology sort
	 */
	private Stack<String> stackForTopologySort = null;
	
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
		//for topology sort
		stackForTopologySort = new Stack<>();
	}

	/**
	 * depth first search
	 * visit one node push it to stack
	 * 
	 * @return the visit stack
	 */
	public Stack< String > DFS(){
		initGraph();
	    Stack<String> stackForDfs = new Stack<>();
		for(int i = 0; i < nodes.length; i++){
			if ( !markNode[ i ] ) {
				markNode[ i ] = true;
				dfs_bfsSequence.push(nodes[ i ]);
				stackForDfs.push(nodes[ i ]);
				DFSExplore( i, stackForDfs );
			}
		}
		return dfs_bfsSequence;
	}
	
	private void DFSExplore(int index, Stack<String> stackForDfs){
		for (int i = 0; i < adjacencyMatrix[ index ].length; i++) {
			if (adjacencyMatrix[ index ][ i ] == 1 && !markNode[ i ]) {	
				markNode[ i ] = true;
				dfs_bfsSequence.push(nodes[ i ]);
				stackForDfs.push(nodes[ i ]);
				DFSExplore( i, stackForDfs);
			}
		}
		if ( !stackForDfs.isEmpty()) {
			String node = stackForDfs.pop();
			stackForTopologySort.push(node);
			if (!stackForDfs.isEmpty()) {
				node = stackForDfs.peek();
				for (int i = 0; i < nodes.length; i++) {
					if (node.equals(nodes[ i ])) {
						DFSExplore( i, stackForDfs);
						break;
					}
				}
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
	
	/**
	 * 
	 * @return the stack store the order of DFS pop, which also the topology sort order
	 */
	public Stack<String> topologySort(){
		DFS();
		return stackForTopologySort;
	} 
	
	/**
	 * 
	 * @return two-dimensional matrix transitiveClosure 
	 * represents one nodes is reachable from another nodes 
	 * 
	 * 	However, it is not the best transitive-closure algorithm to use for sparse graphs. 
	 * For sparse graphs, you may be better off just doing DFS from each node v in turn, 
	 * keeping track of which nodes are reached from v. 
	 */
	public int[][] warshall(){
		int[][] transitiveClosure = adjacencyMatrix.clone();
		int length = nodes.length;
		//column k扫描
		for (int k = 0; k < length; k++) {
			//row i 扫描
			for (int i = 0; i <length; i++) {
				if (transitiveClosure[ i ][ k ] == 1) {
					//row k 扫描
					for (int j = 0; j < length; j++) {
						if (transitiveClosure[ k ][ j ] == 1) {
							transitiveClosure[ i ][ j ] = 1;
						}
					}
				}
			}
		}
		return transitiveClosure;
	}
}
