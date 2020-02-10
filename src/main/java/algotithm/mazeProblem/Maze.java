package algotithm.mazeProblem;

import java.util.Scanner;
import java.util.Stack;

public class Maze {
	int maze[][];
	//用来表示是否访问过这个点。
	boolean flag[][];
	private int row = 10;
	private int col = 10;
	//存储一条路径
	Stack<Position> stack;

	/**
	 * 初始化迷宫
	 */
	@SuppressWarnings("resource")
	public void init(){
		stack = new Stack<Position>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入迷宫的行数：");
		row = scanner.nextInt();
		System.out.println("请输入迷宫的列数：");
		col = scanner.nextInt();
		System.out.println("请输入"+row+"行"+col+"列的迷宫：");
		int temp = 0;
		maze = new int[row][col];
		flag = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp = scanner.nextInt();
				maze[i][j] = temp;
				flag[i][j] = false;
			}
		}
	}
	
	/**
	 * 回溯查找，看是否有出路
	 */
	public Stack<Position> findPath(){
		//加入围墙，防止越界
		int temp[][] = new int[row+2][col+2];
		for (int i = 0; i <row+2; i++) {
			for (int j = 0; j <col+2; j++) {
				temp[i][j] = 1;
			}
		}
		//将要查找的迷宫加入到围墙中
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp[i+1][j+1] = maze[i][j];
			}
		}
		
		//从（1，1）开始从左到右查询，一直到（row+1, col+1）
		int i =1;
		int j = 1;
		flag[i-1][j-1] = true;
		stack.push(new Position(i, j));
		while (!stack.empty() && (!((i == row) && (j == col)))) {
			if((temp[i][j+1] == 0) && (flag[i-1][j] == false)){
				flag[i-1][j] = true;
				stack.push(new Position(i, j+1));
				j++;
			}else if((temp[i+1][j] == 0) && (flag[i][j-1] == false)){
				flag[i][j-1] = true;
				stack.push(new Position(i+1, j));
				i++;
			}else if((temp[i][j-1] == 0) && (flag[i-1][j-2] == false)){
				flag[i-1][j-2] = true;
				stack.push(new Position(i, j-1));
				j--;
			}else if((temp[i-1][j] == 0) && (flag[i-2][j-1] == false)){
				flag[i-2][j-1] = true;
				stack.push(new Position(i-1, j));
				i--;
			}else {
				stack.pop();
				if (stack.empty()) {
					break;
				}
				i = stack.peek().row;
				j = stack.peek().col;
			}
		}
		return stack;
	}
	
	//打印查找结果
	public void result_dispaly(){
		Stack<Position> newStack = new Stack<Position>();
		if (stack.empty()) {
			System.out.println("没有出路");
		}else {
			System.out.println("有路径");
		}
		while (!stack.empty()) {
			Position temp = new Position();
			temp = stack.pop();
			newStack.push(temp);
		}
		
		String[][] result = new String[row+1][col+1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = (maze[i][j])+"";
			}
		}
		while(!newStack.empty()){
			Position p = newStack.pop();
			result[p.row-1][p.col-1]="#";
		}
		for (int i = 0; i <row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
