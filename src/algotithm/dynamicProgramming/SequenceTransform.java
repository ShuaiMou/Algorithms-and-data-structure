package algotithm.dynamicProgramming;

public class SequenceTransform {
	private static int transform(int[] original, int[] destination){
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
	
	private  static int transform2(int[] original, int[] destination){
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
	
	public static void main(String[] args) {
		int[] original = {2,1,7};
		int[] destination = {};
		System.out.println(SequenceTransform.transform(original, destination));
		System.out.println(SequenceTransform.transform2(original, destination));
	}
}
