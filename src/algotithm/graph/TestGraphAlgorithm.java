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
			{"A","C"},
			{"A","D"},
			{"A","F"},
			{"B","C"},
			{"C","D"},
			{"E","G"},
			{"D","G"},
			{"I","J"},
			{"J","G"}
		};
		Graph graph = new Graph(nodes, edges);
		graph.setDirectedGraph(true);
		graphAlgorithm = new GraphAlgorithms(graph.getAdjacencyMatrixRepresentation(), nodes);
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
}
