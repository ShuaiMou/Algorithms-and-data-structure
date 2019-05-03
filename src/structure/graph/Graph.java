package structure.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private Map<String, List<String>> graph = new HashMap<>();
	public void initGraphData(){
		graph.put("1", Arrays.asList("2","3"));
		graph.put("2", Arrays.asList("1","4","5"));
		graph.put("3", Arrays.asList("1","6","7"));
		graph.put("4", Arrays.asList("2","8"));
		graph.put("5", Arrays.asList("2","8"));
		graph.put("6", Arrays.asList("3","8","9"));
		graph.put("7", Arrays.asList("3","9"));
		graph.put("8", Arrays.asList("4","5","6"));
		graph.put("9", Arrays.asList("6","7"));
	}
	
	/**
	 * 广度优先遍历BFS
	 * 使用队列实现
	 */
	private Queue<String> queue = new LinkedList<>();
	private Map<String, Boolean> status = new HashMap<>();
	
	public void BFSSearch(String starPoint){
		queue.add(starPoint);
		status.put(starPoint,false);
		bfsLoop();
	}
	private void bfsLoop(){
		//从queue中取出队列头的点；更新状态为已经遍历。
		String currentQueueHeader = queue.poll();
		status.put(currentQueueHeader, true);
		System.out.print(currentQueueHeader+" ");
		//找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
		List<String> neighbourPoints = graph.get(currentQueueHeader);
		for (String point : neighbourPoints) {
			if (!status.getOrDefault(point, false)) { //未被遍历
				if (queue.contains(point)) {
					continue;
				}
				queue.add(point);
				status.put(point, false);	
			}
		}
		if (!queue.isEmpty()) {  //若队列不为空继续遍历
			bfsLoop();
		}	
	}
	
	/**
	 * 深度优先遍历DFS
	 * 使用栈实现
	 */
	private Stack<String> stack = new Stack<>();
	public void DFSSearch(String startPoint){
		stack.push(startPoint);
		status.put(startPoint, true);
		dfsLoop();
	}
	private void dfsLoop(){
		if (stack.empty()) {
			return;
		}
		//查看栈顶元素，但并不出栈
		String stackTopPoint = stack.peek();
		//找出与此点邻接但且尚未遍历但点，进行标记，然后全部放入stack中
		List<String> neighbourPoints = graph.get(stackTopPoint);
		for (String point : neighbourPoints) {
			if (!status.getOrDefault(point, false)) {//未被遍历
				stack.push(point);
				status.put(point, true);
				dfsLoop();
			}
		}
		String popPoint = stack.pop();
		System.out.print(popPoint+" ");
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.initGraphData();
		graph.BFSSearch("1");
		//graph.DFSSearch("1");
	}
}
