package structure.tree;

import org.junit.Before;
import org.junit.Test;

public class TestCase {
	int[] array ;
	BinarySortTree tree;
	@Before
	public void before(){
		int[] array1 = {8,1,5,2,6,4,3,9,7};
		array = array1;
		tree = new BinarySortTree();
	}
	@Test
	/**
	 * input {8,1,5,2,6,4,3,9,7}
	 * test iterInsert() 
	 */
	public void testBinarySortTree1(){
		for (int i = 0; i < array.length; i++) {
			tree.iterInsert(tree.getRoot(), array[i]);
		}
		tree.preOrderTraverse();
	}
	
	@Test
	/**
	 * input {8,1,5,2,6,4,3,9,7}
	 * test findMAx,findMin(recursion or not)
	 */
	public void testBinarySortTree2(){
		tree.insert(array);
		//System.out.println(tree.getRoot().toString());
		tree.findMax(tree.getRoot()).display();
		tree.iterfindMax(tree.getRoot()).display();
		tree.findMin(tree.getRoot()).display();
		tree.iterfindMin(tree.getRoot()).display();
	}
	
	@Test
	/**
	 * test remove(TreeNode root, int value)
	 */
	public void testBinarySortTree3(){
		tree.insert(array);
		tree.preOrderTraverse();
		tree.remove(6);
		tree.preOrderTraverse();
	}

}
