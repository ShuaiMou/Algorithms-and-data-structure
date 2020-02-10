package algotithm.sort;

/**
 * decrease and conquer
 * 插入排序(in place, stable)
 *time complexity value is O(n^2)
 * 
 * @author Saul
 * 2019-04-28
 *
 */
public class InsertionSort {
	public void insertSort(int[] array){
		int len = array.length;
		int v;
		int j;
		for (int i = 1; i < len; i++) {
			v = array[i];
			j = i - 1;
			while( j >= 0 && v < array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = v;
		}
	}
}
