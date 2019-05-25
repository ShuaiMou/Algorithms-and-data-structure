package algotithm_test.assignment2;

import structure.tree.BinarySortTree;
import structure.tree.TreeNode;

public class RangeCount {
	public int rangeCount(TreeNode T, int lo, int hi){
		if(T == null)
			return 0;
		if (T.getValue() < lo) {
			return rangeCount(T.getRchild(),lo,hi);
		}else if(T.getValue() > hi){
			return rangeCount(T.getLchild(),lo,hi);
		}else {
			return 1 + rangeCount(T.getRchild(),lo,hi) + rangeCount(T.getLchild(),lo,hi);
		}
	}
	
	public static void main(String[] args) {
		RangeCount rangeCount = new RangeCount();
		int[] array = {8,1,5,2,6,4,3,9,7};
		BinarySortTree tree = new BinarySortTree();
		tree.insert(array);
		tree.preOrderTraverse();
		System.out.println(rangeCount.rangeCount(tree.getRoot(), 3, 8));
	}
}
