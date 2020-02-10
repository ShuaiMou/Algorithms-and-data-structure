package algotithm_test;

public class Solution {
    public static String convert(String s, int numRows) {
        int length = 0;
        int col = 0;
        int row = numRows - 2;
        int column = 1;
        if (numRows > 1) {
        	column =(int) Math.ceil((numRows - 1)*(s.length()/(2.0*numRows - 2))) + 1;
		}
        if (numRows == 1) {
			return s;
		}
        String result = "";
        char[][] output = new char[numRows][column];
        for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < column; j++) {
				output[i][j] = '1';
			}
		}
        while( length < s.length() ){
            for(int i = 0; i < numRows && length < s.length(); i++){
                output[i][col] = s.charAt(length++);
            }
            col++;
            while(col%(numRows-1) != 0 && length < s.length() && col < column){
                output[row--][col++] = s.charAt(length++);
            }
            row = numRows - 2;  
        }
       
        for(int i = 0; i < numRows; i++){
        	for (int j = 0; j < column; j++) {
				if (output[i][j] != '1') {
					result = result + output[i][j];
				}
			}
        }
        return result;
    }
    public static void main(String[] args) {
		String s = "a"; 
		int numRows = 1;
		System.out.println(Solution.convert(s, numRows));

	}
}
