package structure.tree;

public class TreeNode {
	private int value;
	private TreeNode lchild;
	private TreeNode rchild;
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLchild() {
		return lchild;
	}

	public void setLchild(TreeNode lchild) {
		this.lchild = lchild;
	}

	public TreeNode getRchild() {
		return rchild;
	}

	public void setRchild(TreeNode rchild) {
		this.rchild = rchild;
	}

	
	public TreeNode() {
		super();
	}

	public TreeNode(int value) {
		this(value, null, null);
	}

	public TreeNode(int value, TreeNode lchild, TreeNode rchild) {
		super();
		this.value = value;
		this.lchild = lchild;
		this.rchild = rchild;
		
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", lchild=" + lchild + ", rchild=" + rchild + "]";
	}
	
	public void display(){
		System.out.print(this.value + "\t");
	}
	
}
