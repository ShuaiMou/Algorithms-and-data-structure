package algotithm.sort;

/**
 * 选择排序(in place, unstable)
 * time complexity value is O(n^2)
 * 
 * @author Saul
 * 2019-04-28
 *
 */
public class SelectionSort {
	
	public void selSort(int[] array){
		int min = 0;
		int temp;
		int length = array.length;
		for (int i = 0; i < length -1; i++) {
			min = i;
			for (int j = i + 1; j < length; j++) {
				if(array[j] < array[min] ){
					min = j;
				}
			}
			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
