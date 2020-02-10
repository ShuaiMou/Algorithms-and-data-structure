package algotithm.sort;
/**
 * 希尔排序(in place, unstable)
 * time complexity value is O(nlgn) 
 * 
 * @author Saul
 * 2019-04-28
 *
 */
public class ShellSort {
	public void shellsort(int[] array){
		for(int gap = array.length/2; gap > 0; gap/=2){
			for(int i = gap; i < array.length; i++){
				int j = i-gap;
				int temp = array[i];
				while( j >= 0 && temp < array[j]){
					array[j+gap] = array[j];
					j-=gap;
				}
				array[j+gap] = temp;
			}
		}
	}
}
