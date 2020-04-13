package algotithm.sort;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestCase {
	int[] array = {3,4,8,2,1,6,6,7};
	
	@Test
	/**
	 * 输入无序整型数组，用选择排序进行排序
	 * 
	 * Saul
	 * 2019-04-28
	 */
	public void testSelctionSort(){
		SelectionSort sort = new SelectionSort();
		sort.selSort(array);
	}
	
	@Test
	/**
	 * 输入无序整型数组，用插入排序进行排序
	 * 
	 * Saul
	 * 2019-04-28
	 */
	public void testInsertionSort(){
		InsertionSort sort = new InsertionSort();
		sort.insertSort(array);
	}
	@Test
	/**
	 * 输入无序整型数组，用希尔排序进行排序
	 * 
	 * Saul
	 * 2019-04-28
	 */
	public void testShellsort(){
		ShellSort sort = new ShellSort();
		sort.shellsort(array);
	}

	@Test
	public void testPriorityQueue(){
		PriorityQueue<int[][]> queue = new PriorityQueue<>(new Comparator<int[][]>() {
            @Override
            public int compare(int[][] o1, int[][] o2) {
                return o1[1][0] - o2[1][0];
            }
        });
		int[] a = new int[]{1,2};
        queue.add(new int[][]{a,{3}});
        queue.add(new int[][]{{2, 4},{8}});
        queue.add(new int[][]{{0, 0},{5}});
        System.out.println(queue.peek()[0][0]);
        System.out.println(queue.poll()[0][1]);

	}
	
	@After
	public void after(){
		System.out.println(Arrays.toString(array));
	}
}
