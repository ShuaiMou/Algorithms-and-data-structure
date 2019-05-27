package algotithm.DynamicProgram;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicProgram {
	DynamicProgramming dynamic = null;
	
	@Before
	public void init(){
		dynamic = new DynamicProgramming();
	}
	
	@Test
	public void testCoinRowProblem(){
		int[] coinRow = {1, 2, 8, 9, 3, 4, 2};
		assert dynamic.CoinRowProblem(coinRow) ==15;
	}
	
	@Test
	public void testKnapsackProlem(){
		int[] weights = {7, 3, 4, 5};
		int[] values = {42, 12, 40, 25};
		int capacity = 8;
		assert dynamic.KnapsackProlem(weights, values, capacity) == 52;
	}
}
