package structure.tree;

import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class TestCase {
	int[] array ;
	int[] array_height;
	BinarySortTree tree;
	AVL avlTree = new AVL();
	@Before
	public void before(){
		int[] array1 = {8,1,5,2,6,4,3,9,7};
		int[] array2 = {1,2,3,4,5,6,7,8,9};
		array = array1;
		array_height = array2;
		tree = new BinarySortTree();
		avlTree = new AVL();
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
	
	@Test
	/**
	 * test height(TreeNode root)
	 */
	public void testBinarySortTree4(){
		tree.insert(array_height);
		System.out.println(tree.height());
	}
	@Test
	/**
	 * Test AVL tree
	 */
	public void testAVLTree1(){
		LinkedList<TreeNode> trace = new LinkedList<TreeNode>();
		avlTree.insert(1, trace);
		avlTree.insert(2, trace);
		avlTree.insert(3, trace);
		avlTree.preOrderTraverse(avlTree.getRoot());
		while(!trace.isEmpty()){
			System.out.println(trace.pop().getValue());
		}	
	}
}
