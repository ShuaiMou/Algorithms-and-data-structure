package algotithm.graph;
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
	int[][] graph;
	int[] nodes;
	int count = 0;
	
	public GraphAlgorithms(int[][] graph){
		this.graph = graph;
		nodes =  new int[ graph.length ];
	}
	/**
	 * 
	 * @param graph use adjacency matrix presentation
	 */
	public void DFS(){
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[ i ] == 0) {
				DFSExplore(i);
			}
		}
	}
	
	private void DFSExplore(int node){
		nodes[ node ] = ++count;
		for (int j = 0; j < graph[ node ].length; j++) {
			if (graph[ node ][ j ] == 1) {
				if (nodes[ j ] == 0) {
					DFSExplore(j);
				}
			}
		}
	}
}
