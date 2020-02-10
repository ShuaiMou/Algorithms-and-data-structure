package structure.tree;

import java.util.LinkedList;

public class AVL {
	private TreeNode root;
	
	public TreeNode getRoot() {
		return root;
	}
	
	public AVL(){
		root = null;
	}
	
	/**
	 * 插入节点值为value的节点，并用栈记录其插入路径(先进后出)
	 * @param value
	 * @param trace
	 * @return
	 */
	public String insert(int value, LinkedList<TreeNode> trace){
		String error = null;
		if(this.root == null){
			this.root = new TreeNode(value);
			return error;
		}
		TreeNode current = root;
		TreeNode newNode = new TreeNode(value);
		while(true){
			trace.push(current);
			if(value < current.getValue()){
				if (current.getLchild() == null) {
					current.setLchild(newNode);
					trace.push(newNode);
					return error;
				}
				current = current.getLchild();
			}else if(value > current.getValue()){
				if(current.getRchild() == null){
					current.setRchild(newNode);
					trace.push(newNode);
					return error;
				}
				current = current.getRchild();
			}else {
				error = "this node has already existed in the tree";
				return error;
			}	
		}
	}
	
	/**
	 * 递归先序遍历
	 * @param root
	 */
	public void preOrderTraverse(TreeNode root){
		TreeNode current = root;
		if (current == null) {
			return;
		}
		System.out.print(current.getValue() + " ");
		preOrderTraverse(current.getLchild());
		preOrderTraverse(current.getRchild());	
	}
	
	public void preOrderTraverse(){
		preOrderTraverse(this.root);
	}
	
}
