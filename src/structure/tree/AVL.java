package structure.tree;

import org.omg.CORBA.Current;

public class AVL {
	private TreeNode root = null;
	
	public void insert(int value){
		TreeNode newNode = new TreeNode(value);
		if(root == null){
			root = newNode;
			root.setLchild(null);
			root.setRchild(null);
		}else {
			while(true){
				TreeNode current = root;
				TreeNode parent = null;
				if(value < current.getValue()){
					parent = current;
					current = current.getLchild();
					if(current == null){
						parent.setLchild(newNode);
						break;
					}
				}
				if (value > current.getValue() ) {
					parent = current;
					current = current.getRchild();
					if (current == null) {
						parent.setRchild(newNode);
						break;
					}
				}
			}
		}
	}
	
	public TreeNode find(int value){
		TreeNode current = root;
		while(true){
			if(current == null){
				return null;
			}
			if(value == current.getValue()){
				return current;
			}
			if(value < current.getValue()){
				current = current.getLchild();
			}
			if (value == current.getValue()) {
				current = current.getRchild();
			}
		}
	}
	
	
}
