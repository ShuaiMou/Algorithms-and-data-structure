package structure.graph;


/**
 * 邻接表无向图(邻接表有向图和邻接表无向图数据结构一样，只是在存储时一个需要存两次，一个需要存一次。)
 * @author moushuai
 *
 */
public class GraphMatrix2 {
	Vertex[] vertexs;
	int size;
	
	class Vertex{ //邻接表节点类，单链表数据结构
		char ch;
		Vertex next;
		
		Vertex(char ch){
			this.ch = ch;
		}
		
		void add(char ch){
			Vertex node = this;
			while(node.next != null){
				node = node.next;
			}
			node.next = new Vertex(ch);
		}
	}

	public GraphMatrix2(char[] vertex, char[][] edges) {
		
		this.size = vertex.length;
		this.vertexs = new Vertex[size];
		//设置邻接表头节点
		for (int i = 0; i < size; i++) {
			this.vertexs[i] = new Vertex(vertex[i]);
		}
		//储存边信息
		for(char[] c: edges){
			int p1 = getPosition(c[0]);
			vertexs[p1].add(c[1]);
			int p2 = getPosition(c[1]);
			vertexs[p2].add(c[0]);
			
		}
	}
	
	private int getPosition(char ch){
		for(int i=0; i<size; i++){
			if (vertexs[i].ch == ch) {
				return i;
			}
		}
		return -1;
	}
	
	//遍历输出邻接表
	public void print(){
		for(int i=0; i<size; i++){
			Vertex temp = vertexs[i];
			while(temp != null){
				System.out.print(temp.ch+" ");
				temp = temp.next;
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
		GraphMatrix2 gMaterix;
		gMaterix = new GraphMatrix2(vexs, edges);
		gMaterix.print();
	
	}
	
	
}
