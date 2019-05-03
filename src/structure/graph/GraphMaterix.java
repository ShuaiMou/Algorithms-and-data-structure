package structure.graph;
/**
 * 邻接矩阵无向图（有向图只需存储martrix[p1][p2]即可，不需要双向）
 * 
 * 
 * @author moushuai
 *
 */
public class GraphMaterix {
	int size; //图顶点个数
	char[] vertexs; //图顶点名称
	int[][] martrix;  //图关系矩阵
	
	public GraphMaterix(char[] vertexs, char[][] edges){
		this.size = vertexs.length;
		this.martrix = new int[size][size];
		this.vertexs = vertexs;
		
		for (char[] cs : edges) {
			int p1 = getPosition(cs[0]);
			int p2 = getPosition(cs[1]);
			martrix[p1][p2] = 1;
			martrix[p2][p1] = 1;
		}
	}
	
	 //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        for(int i=0; i<vertexs.length; i++)
            if(vertexs[i]==ch)
                return i;
        return -1;
    }
    
    public void print(){
    	for (int[] i : martrix) {
			for (int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
    }
    
    public static void main(String[] args) {
		char[] vexs = {'A','B','C','D','E','F','G','H','I','J','K'};
		char[][] edges = new char[][]{
			{'A','C'},
			{'A','D'},
			{'A','F'},
			{'B','C'},
			{'C','D'},
			{'E','G'},
			{'D','G'},
			{'I','J'},
			{'J','G'}
		};
		GraphMaterix gMaterix;
		gMaterix = new GraphMaterix(vexs, edges);
		gMaterix.print();
	
	}

}