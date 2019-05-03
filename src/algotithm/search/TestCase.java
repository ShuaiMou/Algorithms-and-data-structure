package algotithm.search;

import org.junit.Test;

public class TestCase {
	int[] array = {3,4,5,6,7,9,10,18,33,45,67};
	@Test
	/**
	 * 输入有序数组，进行二分查找
	 */
	public void testBinarySearch(){
		BinarySearch search = new BinarySearch();
		int index = search.binaSearch(array, 1);
		int index2 = search.binaSearch(array, 0, array.length-1, 3);
		System.out.println(index + " "+ index2);
	}
	@Test
	/**
	 * 快速查找第k大的数
	 */
	public void testQuickSelect(){
		QuickSelect select = new QuickSelect();
		int result = select.quickSelect(array, 0, array.length - 1, 2);
		System.out.println(result);
	}
	
	@Test
	/**
	 * 输入有序数组，进行插值查找
	 * 对二分查找的优化，适合于数字之间间隔不大的查找
	 */
	public void testInterpolationSearch(){
		InterpolationSearch search = new InterpolationSearch();
		int index = search.interpolationSearch(array, 100);
		System.out.println(index);
	}
}
