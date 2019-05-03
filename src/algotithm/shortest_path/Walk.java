package algotithm.shortest_path;



public class Walk {
	
	public int walk(int[][] matrix, int i, int j) {
		int right = 10000;
		int down = 10000;
		if (i == matrix.length-1 && j == matrix[0].length-1) {
			return matrix[i][j];
			
		}
		if (i == matrix.length - 1 ) {
			return matrix[i][j] + walk(matrix, i, j+1);
		}
		if (j == matrix[0].length - 1) {
			return matrix[i][j] + walk(matrix, i+1, j);
		}
		
		right = matrix[i][j] + walk(matrix, i, j+1);
		down =  matrix[i][j] + walk(matrix, i+1, j);
		
		return Math.min(right,down);
		
	}
	
	public static void main(String[] args) {
		Walk walk = new Walk();
		int[][] A = new int[][]{{0,0,0},
								{0,1,1},
								{1,1,0}};
		int result = walk.walk(A, 0, 0);
		System.out.println(result);
	}
}
