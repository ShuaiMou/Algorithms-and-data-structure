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
}
