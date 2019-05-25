package algotithm.DynamicProgram;

public class DynamicProgramming {
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
}
