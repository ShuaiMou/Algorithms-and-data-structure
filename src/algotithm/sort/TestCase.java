package algotithm.sort;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;

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
	
	@After
	public void after(){
		System.out.println(Arrays.toString(array));
	}
}
