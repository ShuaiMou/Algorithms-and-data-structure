package structure.graph;

import org.junit.Before;
import org.junit.Test;

public class TestGraph {
	private String[][] edges;
	private String[] nodes;
	private Graph graph;
	
	@Before
	public void before(){
		String[] temp = {"A","B","C","D","E","F","G","H","I","J","K"};
		nodes =temp;
		edges = new String[][]{
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
		graph = new Graph(nodes, edges);
	}
	
	//undirected
	@Test
	public void testGetAdjacencyMatrixRepresentation(){
		graph.showGraphByMatrix();
	}
	
	//directed
		@Test
	public void testGetAdjacencyMatrixRepresentation2(){
		graph.setDirectedGraph(true);
		graph.showGraphByMatrix();
	}
	
	//undirected
	@Test
	public void testAdjacencyListRepresentation(){
		graph.showGraphByList();
	}
	
	//directed
		@Test
	public void testAdjacencyListRepresentation2(){
		graph.setDirectedGraph(true);
		graph.showGraphByList();
	}
	
	//directed
		@Test
	public void testGetAdjacencyWeightMatrix(){
		//graph.setDirectedGraph(true);
		int[][] matrix = graph.getAdjacencyWeightMatrix();
		for (int[] temp : matrix) {
			for (int i : temp) {
				System.out.print(" "+ i);
			}
			System.out.println();
		}
	}	
}
