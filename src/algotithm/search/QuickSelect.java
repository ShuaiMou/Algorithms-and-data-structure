package algotithm.search;
/**
 * 快速查找第k大的数
 * 
 * @author Saul
 * 2019-04-28
 *
 */
public class QuickSelect {
	public int lomutoPartition(int[] array,int low, int high){
		int p = array[low];
		int s = low;
		int temp;
		for(int i = 1; i < high; i++){
			if(array[i] < p){
				s++;
				temp = array[s];
				array[s] = array[i];
				array[i] = temp;
			}
		}
		temp = array[s];
		array[s] = p;
		array[low] = temp;
		return s;
	}
	
	public int quickSelect(int[] array, int low, int high, int k){
		int s = lomutoPartition(array,low,high);
		if(s - low == k -1){
			return array[s];
		}else if(s - low > k - 1){
			return quickSelect(array,low, s-1, k);
		}else {
			return quickSelect(array, s+1, high, k-1-(s-low));
		}
	}
}
