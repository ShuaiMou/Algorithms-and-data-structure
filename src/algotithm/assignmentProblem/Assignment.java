package algotithm.assignmentProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment {
	public int n = 3;           // 记录工作人员数和作业数
	public int isworked[];  // 记录第j号作业是否被做了
	public int expense[][]; // 记录第i号工作人员做第j号工作所需的时间
	public int res[][];     // 记录分配工作记录
	public ArrayList<Integer> counts;  // 记录每次分配的总花费
	public int temp = 1;    // 记录分配次数
	private Scanner input;
	
	public void init() {
		input = new Scanner(System.in);
		// 初始化作业被做记录，默认为0，表示没有被做
		this.isworked = new int[this.n];
		for(int m = 0; m < this.isworked.length; m++){
			this.isworked[m] = 0;
		}
		
		// 初始化每个工人做每项作业的花费信息
		this.expense = new int[this.n][this.n];
		System.out.println("*****************每个工人对应完成每个作业所需花费*******************");
		for(int m = 0; m < this.n; m++){
			for (int i = 0; i < this.n; i++) {
				this.expense[m][i] = input.nextInt();
			}
		}
		
		// 初始化分配工作表，默认都为0，表示没有分配
		this.res = new int[this.n][this.n];
		for(int m = 0; m < this.res.length; m++){
			for(int n = 0; n < this.res[m].length; n++){
				this.res[m][n] = 0;
			}
		}
		
		// 创建花费记录
		this.counts = new ArrayList<Integer>();
	}
	
	/**
	 * 开始计算所有分配花费
	 * @param i
	 * @param count
	 */
	public void work(int i, int count){
		// 回溯
		if(i>=this.n){
			// 将本次分配结果的花费添加到花费集中
			this.counts.add(count);
			System.out.println("第" + this.temp + "次分配，此次花费为：" +count);
			System.out.println("本次分配详情：");
			for(int m = 0; m < this.res.length; m++){
				for(int n = 0; n < this.res[m].length; n++){
					System.out.print(this.res[m][n] + " ");
				}
				System.out.println();
			}
			return ;
		}
		
		// 如果当前工作没被做就分配给当前员工
	    for(int j = 0; j < this.n; j++){
	    	if(this.isworked[j] == 0){  
	    		this.isworked[j] = 1;  
	    		this.res[i][j] = 1;
	  	        work(i+1, count + this.expense[i][j]);  
	  	        this.isworked[j] = 0;
	  	        this.res[i][j] = 0;
	  	    }
	    } 
	}
	
	/**
	 * 输出最少花费
	 */
	public void returnlowres(){
		Collections.sort(this.counts);
		System.out.println("******************最少花费********************");
		System.out.println(this.counts.get(0));
	}

	public static void main(String[] args) throws Exception {
		Assignment demo = new Assignment();
		int count = 0;
		demo.init();
		System.out.println("************分配结果************");
		demo.work(0, count);
		demo.returnlowres();
		
	}

}
