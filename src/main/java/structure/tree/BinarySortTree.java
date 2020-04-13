package structure.tree;

import java.util.Stack;

/**
 * 二叉排序树（二叉查找树）
 * (Binary Sort Tree, Binary Search Tree)
 * @author moushuai
 *
 */
public class BinarySortTree {
	//根节点
	private TreeNode root = null;
	
	public TreeNode getRoot(){
		return root;
	}
	
	public void setRoot(TreeNode root){
		this.root = root;
	}
	
	public BinarySortTree(int value){
		root = new TreeNode(value);
		root.setLchild(null);
		root.setRchild(null);
	}
	
	public BinarySortTree(){
		root = null;
	}
	
	/**
	 * 非递归方式: 查找值为value的节点，并返回.
	 * 
	 * @param value
	 * @return
	 */
	public TreeNode findValue(TreeNode root, int value){
		TreeNode current = root;
		while(current != null){
			if (value == current.getValue()) {
				return current;
			}else if (value < current.getValue() ) {
				current = current.getLchild();
			}else if (value > current.getValue()) {
				current = current.getRchild();
			}
		}
		return null;
	}
	
	/**
	 *  递归方式：查找值为value的节点，并返回该节点，若不存在，则返回null
	 *  
	 * @param root
	 * @param value
	 * @return
	 */
	public TreeNode iterFindValue(TreeNode root, int value){
		TreeNode current = root;
		if (current == null) {
			return null;
		}
		if(value < current.getValue()){
			return iterFindValue(current.getLchild(), value);
		}else if(value > current.getValue()){
			return iterFindValue(current.getRchild(), value);
		}else {
			return current;
		}
	}
	
	public TreeNode findValue(int value){
		return findValue(this.root, value);
	}
	
	/**
	 * 非递归方式
	 * 插入数据：与查找数据类似，不同点在于数据为空时，不是返回而是插入
	 * 
	 * @param value
	 * @return
	 */
	public String insert(TreeNode root, int value){
		String error = null;
		TreeNode newNode = new TreeNode(value);
		if ( this.root == null) {
			this.root = newNode;
			this.root.setLchild(null);
			this.root.setRchild(null);
		}else {
			TreeNode current = root;
			TreeNode parent = null;
			while(true){
				if(value < current.getValue()){
					parent = current;
					current = current.getLchild();
					if (current == null) {
						parent.setLchild(newNode);
						break;
					}
				}else if (value > current.getValue()) {
					parent = current;
					current = current.getRchild();
					if (current == null) {
						parent.setRchild(newNode);
						break;
					}
				}else {
					error = "having same value in binary tree";
				}
			}
		}
		return error;
	}
	
	/**
	 * 递归方式： 插入value节点，成功返回。
	 *  
	 * @param root
	 * @param value
	 * @return
	 */
	public TreeNode iterInsert(TreeNode root, int value){
		TreeNode newNode = new TreeNode(value);
		TreeNode current = root;
		if (this.root == null) {
			this.root = newNode;
			this.root.setLchild(null);
			this.root.setRchild(null);
			return this.root;
		}
		if(current == null){
			current = newNode;
		}
		if (value < current.getValue()) {
			 current.setLchild(iterInsert(current.getLchild(), value));
		}else if(value > current.getValue()){
			current.setRchild( iterInsert(current.getRchild(), value));
		}
		return current;
	}
	
	public String insert(int value){
		return insert(this.root, value);
	}
	
	public void insert(int[] array){
		for (int i = 0; i < array.length; i++) {
			insert(array[i]);
		}
	}
	
	/**
	 * 查找最小元素，递归
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode iterfindMin(TreeNode root){
		if(root == null){
			return null;
		}else if(root.getLchild() == null){
			return root;
		}else {
			return iterfindMin(root.getLchild());
		}
	}
	
	/**
	 * 查找最小元素：非递归
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode findMin(TreeNode root){
		if (root == null) {
			return null;
		}
		while(root.getLchild() != null){
			root = root.getLchild();
		}
		return root;
	}
	
	public TreeNode findMin(){
		return findMin(this.root);
	}
	
	/**
	 * 查找最大元素，递归
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode iterfindMax(TreeNode root){
		if(root == null){
			return null;
		}else if (root.getRchild() == null){
			return root;
		}else {
			return iterfindMax(root.getRchild());
		}
	}
	
	/**
	 * 找到最大元素，非递归
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode findMax(TreeNode root){
		if(root == null){
			return null;
		}
		while (root.getRchild() != null) {
			root = root.getRchild();
		}
		return root;
	}
	
	public TreeNode findMax(){
		return this.findMax(this.root);
	}
	
	/**
	 * 删除元素
	 * @param root
	 * @param value
	 * @return
	 */
	public void remove(TreeNode root, int value){
		TreeNode head = root;
		TreeNode parent = head;
		TreeNode temp;
		while(head != null && value != head.getValue()){
			parent = head;
			if (value < head.getValue()) {
				head = head.getLchild();
			}else if(value > head.getValue()){
				head = head.getRchild();
			}
		}
		if (head == null) {
			System.out.println("the node is not exists in this tree");
		}else if(head.getLchild() != null && head.getRchild() != null){
			temp = head.getLchild();
			parent = head;
			while(temp.getRchild() != null){//找到前驱节点
				parent = temp;
				temp = temp.getRchild();
			}
			head.setValue(temp.getValue());
			if(parent == head){
				head.setLchild(temp.getLchild());
			}else {
				parent.setRchild(temp.getLchild());
			}
		}else if (head.getLchild() == null && head.getRchild()!= null) {
			temp = head.getRchild();
			head.setValue(temp.getValue());
			head.setRchild(temp.getRchild());
			head.setLchild(temp.getLchild());
		}else if(head.getRchild() == null && head.getLchild() != null){
			temp = head.getLchild();
			head.setValue(temp.getValue());
			head.setRchild(temp.getRchild());
			head.setLchild(temp.getLchild());
		}else{
			if (parent.getRchild() == head) {
				parent.setRchild(null);
			}else {
				parent.setLchild(null);
			}
		}
		
	}
	
	public void remove(int value){
		remove(this.root, value);
	}
	
	/**
	 * to get the height of the tree
	 * @param root
	 * @return
	 */
	public int height(TreeNode root){
		if (root == null) {
			return -1;
		}else {
			return Math.max(height(root.getLchild()), height(root.getRchild())) + 1;
		}
	}
	
	public int height(){
		return height(root);
	}
	/**
	 * 中序遍历（递归）
	 * 1.调用自身来遍历节点左子树
	 * 2.访问这个节点
	 * 3.调用自身来遍历节点的右子树
	 * @param node
	 */
	public void inOrderTraverse(TreeNode node){
		if (node == null) {
			return;
		}
		inOrderTraverse(node.getLchild());
		node.display();
		inOrderTraverse(node.getRchild());
	}
	public void inOrderTraverse(){
		System.out.println("中序递归遍历：");
		inOrderTraverse(root);
		System.out.println();
	}
	/**
	 * 中序非递归遍历：
	 * 1.对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复进行，直至current为空
	 * 2.若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current。
	 * 3.重复1，2步，直至current为空且栈内节点为空。
	 */
	public void inOrderByStack(){
		System.out.println("中序非递归遍历：");
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.getLchild();
			}
			if (!stack.isEmpty()) {
				current = stack.pop();
				current.display();
				current = current.getRchild();
			}
			
		}
		System.out.println();
		
	}
	
	/**
	 * 前序遍历（递归）
	 * 1.访问这个节点
	 * 2.调用自身来遍历节点左子树
	 * 3.调用自身来遍历节点的右子树
	 * @param node
	 */
	public void preOrderTraverse(TreeNode node){
		if (node == null) {
			return;
		}
		node.display();
		preOrderTraverse(node.getLchild());
		preOrderTraverse(node.getRchild());
	}
	public void preOrderTraverse(){
		System.out.println("前序递归遍历：");
		preOrderTraverse(root);
		System.out.println();
	}
	/**
	 * 前序非递归遍历：
	 * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
	 * 2.若左子树为空，栈顶节点出栈，将该节点的右子树置为current
	 * 3.重复1、2步操作，直到current为空且栈内节点为空。
	 */
	public void preOrderByStack(){
		System.out.println("前序非递归遍历：");
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while(!stack.empty() || current != null){
			while(current != null){
				stack.push(current);
				current.display();
				current = current.getLchild();
			}
			if(!stack.isEmpty()){
				current = stack.pop().getRchild();
				
			}
		}
		System.out.println();
		
	}
	/**
	 *后序遍历（递归）
	 * 1.调用自身来遍历节点左子树
	 * 2.调用自身来遍历节点的右子树
	 * 3.访问这个节点
	 * @param node
	 */
	public void postOrderTraverse(TreeNode node){
		if (node == null) {
			return;
		}
		postOrderTraverse(node.getLchild());
		postOrderTraverse(node.getRchild());
		node.display();
	}
	public void postOrderTraverse(){
		System.out.println("后序递归遍历：");
		postOrderTraverse(root);
		System.out.println();
	}
	/**
	 * 后序遍历（非递归）
	 * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
	 * 2.若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
	 * 3.重复1、2步操作，直到current为空且栈内节点为空。
	 */
	public void postOrderByStack(){
		System.out.println("后序非递归遍历");
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		TreeNode preNode = null;
		while(current != null || !stack.empty()){
			while(current != null){
				stack.push(current);
				current.getLchild();
			}
			if (!stack.empty()) {
				current = stack.peek().getRchild();
				if ((current == null) || (current == preNode)) {
					current = stack.pop();
					current.display();
					preNode = current;
					current = null;
				}
			}
		}
		System.out.println();	
	}
	
}
