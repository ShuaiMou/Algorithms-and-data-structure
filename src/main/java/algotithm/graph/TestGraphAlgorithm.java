package algotithm.graph;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import structure.graph.Graph;

public class TestGraphAlgorithm {
	private GraphAlgorithms graphAlgorithm;

	@Before
	public void before(){
		String[] nodes = {"A","B","C","D","E","F","G","H","I","J","K"};

		String[][] edges = new String[][]{
			{"A","C","3"},
			{"A","D","2"},
			{"A","F","1"},
			{"B","C","4"},
			{"C","D","6"},
			{"E","G","8"},
			{"D","G","9"},
			{"I","J","2"},
			{"J","G","3"}
		};
		Graph graph = new Graph(nodes, edges);
		graph.setDirectedGraph(true);
		graphAlgorithm = new GraphAlgorithms(graph.getAdjacencyMatrixRepresentation(), nodes, graph.getAdjacencyWeightMatrix());
	}
	
	/**
	 * the sequence of pop is the reverse order of the visit order
	 */
	@Test
	public void testDFS(){
		Stack<String> stack = graphAlgorithm.DFS();
		while( !stack.isEmpty() ){
			System.out.print(" " + stack.pop());
		}
	}
	
	/**
	 * the sequence of pop is the reverse order of the visit order
	 */
	@Test
	public void testBFS(){
		Stack<String> stack = graphAlgorithm.BFS();
		while( !stack.isEmpty() ){
			System.out.print(" " + stack.pop());
		}
	}
	
	/**
	 * set directedGraph as true before this test.
	 */
	@Test
	public void testTopologySort(){
		Stack<String> stack = graphAlgorithm.topologySort();
		while( !stack.isEmpty() ){
			System.out.print(" " + stack.pop());
		}
	}
	
	/**
	 * set directedGraph as true before this test.
	 */
	@Test
	public void testWarshall(){
		int[][] transitiveClosure = graphAlgorithm.warshall();
		for (int[] temp : transitiveClosure) {
			for (int link : temp) {
				System.out.print(" " + link);
			}
			System.out.println();
		}
	}
	
	@Test
	public void testFloyd(){
		int[][] distance = graphAlgorithm.floyd();
		for (int[] temp : distance) {
			for (int dis : temp) {
				System.out.printf("%-8d", dis);
			}
			System.out.println();
		}
	}
}
