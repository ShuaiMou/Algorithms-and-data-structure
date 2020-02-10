package algotithm_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecimalToBinary {
	public String convert(int number){
		List<Byte> list = new ArrayList<Byte>();
		Byte remainder;
		while(number != 0){
			remainder = (byte) (number%2);
			list.add(remainder);
			number = number/2;
		}
		Collections.reverse(list);
		return list.toString().replaceAll(", ", "").replace("[", "").replace("]", "");
	}
	public static void main(String[] args) {
		DecimalToBinary decimalToBinary = new DecimalToBinary();
		System.out.println(decimalToBinary.convert(8));
	}
}
