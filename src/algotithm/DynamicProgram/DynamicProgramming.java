package algotithm.DynamicProgram;

public class DynamicProgramming {
	
	/**
	 * The Coin-Row Problem 
	 * 	Given a row of coins, pick up the largest possible sum, subject to this constraint: No two adjacent coins can be picked. 
	 * 
	 * @param coinRow
	 * @return
	 */
	public int CoinRowProblem(int[] coinRow){
		int length = coinRow.length;
		int[] result = new int[length + 1];
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				result[ 0 ] = 0;
				result[ i + 1 ] = coinRow[i];
			}else {
				result[ i+1 ] = Math.max(result[ i ], result[ i - 1] + coinRow[i]);
			}
		}
		return result[length];
	}
	
	/**
	 * The Knapsack Problem 
	 * 	Given n items with 
		○ weights: w1,w2,...,wn
		○  values: v1,v2,...,vn 
		○ knapsack of capacity W 
	find the most valuable selection of items that will fit in the knapsack. We assume that all entities involved are positive integers. 
	 * 
	 * @param weights
	 * @param values
	 * @param capacity
	 * @return
	 */
	public int KnapsackProlem(int[] weights, int[] values, int capacity){
		int length1 = weights.length;
		int[][] k = new int[ length1 +1 ][ capacity + 1 ];
		for (int i = 0; i < length1 + 1; i++) {
			k[ i ][ 0 ] = 0;
		}
		for (int i = 0; i <capacity + 1; i++) {
			k[ 0 ][ i ] = 0;
		}
		for (int i = 0; i < length1 ; i++) {
			for (int j = 0; j < capacity + 1 ; j++) {
				if (j < weights[i]) {
					k[ i+1 ][ j + 1 ] = k[ i ][ j + 1 ];
				}else {
					k[ i + 1 ][ j + 1] = Math.max(k[ i  ][ j + 1 ], k[ i  ][ j  - weights[ i ] ] + values[ i ]);
				}
			}
		}
		return k[ length1 ][ capacity ];
	}
	
	/**
	 * sequence transform
	 * 
	 * @param original
	 * @param destination
	 * @return the least step can be done from initial status to destination status
	 */
	public  int transform(int[] original, int[] destination){
		int length1 = original.length;
		int length2 = destination.length;
		int[] array = new int[length1 + 1];
		  /* 如果destination为空，那么转换方式就是将original每个字符删掉，次数就是original的个数 */
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		for(int i = 1; i <= length2; i++){
			int prev = array[0];
			array[0] = i;
			for (int j = 1; j <= length1; j++) {
				int temp = array[j];
				if (original[j - 1] == destination[i - 1]) {
					array[j] = prev;
				}else {
					array[j] = Math.min(prev,Math.min(array[j], array[j-1])) + 1;
				}
				prev = temp;
			}
		}
		return array[length1];
	}
	
	public  int transform2(int[] original, int[] destination){
		int length1 = original.length;
		int length2 = destination.length;
		int[][] array = new int[length1 + 1][length2 + 1];
		//如果目标序列为空，则源序列长度即为转换为目标序列的最少次数。
		for (int i = 0; i < length1+1; i++) {
			array[i][0] = i;
		}
		//如果源序列为空，则目标序列长度即为转换为目标序列的最少次数。
		for (int i = 0; i < length2+1; i++) {
			array[0][i] = i;
		}
		for (int i = 0; i <length2; i++) {
			for (int j = 0; j < length1; j++) {
				if ( original[ j ] == destination[ i ] ) {
					array[ j + 1 ][ i + 1] = array[ j ][ i ];
				}else{
					array[ j + 1 ][ i + 1] = Math.min( array[ j + 1][ i ], Math.min( array[ j ][ i + 1 ], array[ j ][ i ] )) + 1;
				}
			}
		}
		return array[length1][length2];
	}
	
}
