package structure.graph;

import java.util.LinkedList;

/**
 * graph structure, this is used to create a graph by enter a set of vertices and edges.
 * the graph can be represented by adjacency matrix and adjacency list.
 * 
 * if it is a directed graph, before getting the representation the  
 * directedGraph instance variable must be set as true.
 * 
 * @author Saul
 * 2019-06-09
 *
 */
public class Graph {
	/**
	 * a String type array which indicates every nodes in the graph
	 */
	private  String[] nodes;
	
	/**
	 * a two-dimensional array to store edges of the graph,
	 * the number of rows represents the number of edges.
	 * it has three column or two column, the first two represent edges, the thirds is weight.
	 */
	private  String[][] edges;
	
	/**
	 * if the graph is directed, when get the representation, directedGraph should be set as true.
	 * the default value is false.
	 */
	private boolean directedGraph;
	
	public void setDirectedGraph(boolean directedGraph) {
		this.directedGraph = directedGraph;
	}

	public Graph(String[] nodes, String[][] edges) {
		this.nodes = nodes;
		this.edges = edges;
		directedGraph = false;
	}
	
	/**
	 * @return Adjacency Matrix Representation of the graph
	 */
	public int[][] getAdjacencyMatrixRepresentation(){
		int[][] matrix = new int[ nodes.length ][ nodes.length ];
		for( String[] node : edges){
			int indexX = findIndexOfNode(node[0]);
			int indexY = findIndexOfNode(node[1]);
			matrix[ indexX ][ indexY] = 1;
			if ( !directedGraph) {
				matrix[ indexY ][ indexX] = 1;
			}
		}
		return matrix;
	}
	
	/**
	 * 
	 * @param node the name of the node
	 * @return the index of the node in the node array
	 */
	private int findIndexOfNode(String node){
		for(int i = 0; i < nodes.length; i++)
			if (node.equals(nodes[ i ])) 
				return i;
		return -1;
	}
	
	/**
	 * show the graph by adjacency matrix
	 */
	public void showGraphByMatrix(){
		int[][] matrix = getAdjacencyMatrixRepresentation();
		for(int i = 0; i < nodes.length; i++){
			for (int j = 0; j < nodes.length; j++) {
				 System.out.print(" " + matrix[ i ][ j ]);
			}
			System.out.println();
		}
	}
	
	/**
	 * @return Adjacency List Representation of the graph
	 */
	public LinkedList<String>[] getAdjacencyListRepresentation(){
		@SuppressWarnings("unchecked")
		LinkedList<String>[] adjacencyList = new LinkedList[ nodes.length];
	for (int i = 0; i < adjacencyList.length; i++) {
		adjacencyList[ i ] = new LinkedList<>();
		adjacencyList[i].add(nodes[ i ] );
	}
		for(String[] node : edges){
			int index1 = findIndexOfNode(node[0]);
			adjacencyList[ index1 ].add(node[1]);
			if ( !directedGraph ) {
				int index2 = findIndexOfNode(node[1]);
				adjacencyList[ index2 ].add(node[0]);
			}
			
		}
		return adjacencyList;
	}
	
	/**
	 * show the graph by adjacency List
	 */
	public void showGraphByList(){
		LinkedList<String>[] list = getAdjacencyListRepresentation();
		for (LinkedList<String> linkedList : list) {
				while( !linkedList.isEmpty() ){
					System.out.print(" " + linkedList.pop());
				}
				System.out.println();
		}
	}
	
	/**
	 * @return Adjacency weight Matrix Representation of the graph
	 */
	public int[][] getAdjacencyWeightMatrix(){
		int[][] weightedMatrix = new int[ nodes.length ][ nodes.length ];
		for( String[] node : edges){
			int indexX = findIndexOfNode(node[0]);
			int indexY = findIndexOfNode(node[1]);
			int weight = Integer.parseInt(node[2]);
			weightedMatrix[ indexX ][ indexY] = weight;
			if ( !directedGraph) {
				weightedMatrix[ indexY ][ indexX] = weight;
			}
		}
		return weightedMatrix;
	}
}


