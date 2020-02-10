package algotithm_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryToDecimal {
	public Integer convert(List<Byte> binary){
		List<Byte> list = binary;
		int result = 0;
		for (int i = list.size()-1; i >= 0 ; i--) {
			result += (Math.pow(2, i)*list.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
		List<Byte> list = new ArrayList<Byte>();
		Scanner input = new Scanner(System.in);
		Byte byte1;
		while((byte1 = input.nextByte()) == 0 || byte1 == 1){
			list.add(byte1);
		}
		System.out.println(binaryToDecimal.convert(list));
		input.close();
	}
}
