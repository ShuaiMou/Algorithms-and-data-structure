package algotithm.search;

public class StringSearch {
	/**
	 * 
	 * @param pattern  A string of m characters to search for.
	 * @param text   A long string of n characters to search in. 
	 * @return if find the pattern in text, return the start index of the string, otherwise return -1
	 */
	public int bruteForceSearch(String pattern, String text){
		char[] patterns = pattern.toCharArray();
		char[] texts = text.toCharArray();
		for (int i = 0; i < texts.length - patterns.length + 1; i++) {
			int j = 0;
			while(j < patterns.length && patterns[ j ] == texts[ i + j]){
				j++;
			}
			if (j == patterns.length) {
				return i;
			}
		}
		return -1;
	}
}
