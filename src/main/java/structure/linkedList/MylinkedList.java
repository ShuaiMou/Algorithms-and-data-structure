package structure.linkedList;

public class MylinkedList {
	/**
	 * 指向链表中的第一个链结点
	 */
	private Node head;
	
	public MylinkedList(){
		head = null;
	}
	
	/**
	 * 插入到链表的前端
	 * @param node
	 */
	public void insertFirst(Node node){
		node.next = head;
		head = node;
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return (head == null);
	}
	/**
	 * 删除第一个链结点，返回删除链结点的引用
	 * @return
	 */
	public Node deleteFirst(){
		if (isEmpty()) {
			throw new RuntimeException("the linkedList is empty, can not be deteted");
		}
		Node temp = head;
		head  = head.next;
		return temp;
	}
	/**
	 * 删除指定值的元素，并返回该链结点
	 * @param object
	 * @return
	 */
	public Node delete(Object object){
		if (isEmpty()) {
			throw new RuntimeException("the linkedList is empty");	
		}
		Node temp = null;
		Node cur = head;
		Node prev = null;
		while(cur != null){
			if (cur.item.equals(object)) {
				temp = cur;
				if (prev == null) {
					this.head = head.next;
				}else {
					prev.next = cur.next;
				}
				break;
			}
			prev = cur;
			cur = cur.next;	
		}
		return temp;
	}
	
	/**
	 * 在链表尾部增加链结点
	 * @param object
	 */
	public void add(Object object){
		if (isEmpty()) {
			head.item = object;
			head.next = null;
		}else {
			Node temp = head;
			Node newNode = new Node(object, null);
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	
	
	
}
