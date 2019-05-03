package algotithm.search;
/**
 * 插值查找
 * 时间复杂度为O(lglgn)
 * 
 * @author Saul
 * 2019-04-28
 *
 */
public class InterpolationSearch {
	public int interpolationSearch(int[] array, int k){
		int mid = 0;
		int low = 0;
		int high = array.length -1;
		while(low <= high){
			mid = ((k - array[low])/(array[high] - array[low]))*(high - low) + low;
			if (array[mid] == k) {
				return mid;
			}else if(k > array[mid]){
				low = mid +1;
			}else {
				high = mid -1;
			}
		}
		return -1;
	}
}
