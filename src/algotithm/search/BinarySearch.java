package algotithm.search;
/**
 * 二分查找
 * time complexity value is O(lgn)
 * 
 * @author Saul
 * 2019-04-28
 *
 */
public class BinarySearch {
	//not recursion
	public int binaSearch(int[] array, int k){
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		while(low <= high){
			mid = (low + high)/2;
			if(k == array[mid]){
				return mid;
			}
			if (k < array[mid]) {
				high = mid -1;
			}
			if(k > array[mid]){
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//recursion
	public int binaSearch(int[] array,int low, int high, int k){
		if(low > high)
			return -1;
		int mid = (low + high)/2;
		if (k == array[mid]) 
			return mid;
		else if (k < array[mid]) 
			return binaSearch(array, low, mid -1, k);
		else 
			return binaSearch(array, mid + 1, high, k);
	}
		
}
