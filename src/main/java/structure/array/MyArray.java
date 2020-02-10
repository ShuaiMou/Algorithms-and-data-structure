package structure.array;

import java.util.Arrays;

public class MyArray {
	private Object elements[];
	private int size;
	public static final Object[] DEFAULT_ELEMENTS = {};
	public static final Object[] EMPTY_ELEMENTS = {};
	
	//constructor
	public MyArray(int initialCapacity){
		if (initialCapacity > 0) {
			elements = new Object[initialCapacity];
		}else if(initialCapacity == 0){
			elements = EMPTY_ELEMENTS;
		}else {
			throw new RuntimeException("initialCapacity is illegal");
		}
	}
	
	public MyArray(){
		elements = EMPTY_ELEMENTS;
	}
	
	/**
	 * 
	 * @param miniCapacity the desired minimum capacity
	 */
	private void ensureCapacity(int miniCapacity){
		if (miniCapacity >= elements.length) {
			int oldCapacity = elements.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			if (newCapacity - miniCapacity < 0) {
				newCapacity = miniCapacity;
			}
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}
	
	 /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }
	
	/**
	 * 
	 * @return the number of elements in this myArray
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * @return <tt>true</tt> if this list contains no elements
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param object
	 */
	public void add(Object object){
		ensureCapacity(size+1);
		elements[size++] = object;
	}
	/**
	 * Insert the specified element to the specified position of this list.
	 * @param index
	 * @param object
	 */
	 public void add(int index, Object object){
		 rangeCheckForAdd(index);
		 ensureCapacity(size+1); 
		 System.arraycopy(elements, index, elements, index+1, size-index);
		 elements[index] = object;
		 size++;
	 }
	 
	 public void remove(int index){
		 rangeCheckForAdd(index);
		 System.arraycopy(elements, index+1, elements, index, size-index-1);
		 elements[--size] = null;
	 }
	 
	 public void remove(Object object){
		 for (int i = 0; i < size; i++) {
			if (object.equals(elements[i])) {
				remove(i);
			}
		}
	 }
	
	 public void set(int index, Object object){
		 rangeCheckForAdd(index);
		 elements[index] = object;
	 }
	 
	 public Object get(int index){
		 rangeCheckForAdd(index);
		 return elements[index];
	 }
	 
	 public void clear(){
		 for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		 size = 0;
	 }
	 
	 public static void main(String[] args) {
		MyArray array = new MyArray(1);
		System.out.println(array.isEmpty());
		array.add(1);
		array.add("money");
		array.add(3);
		System.out.println(array.size);
		System.out.println(array.isEmpty());
		System.out.println(array.get(1));
		array.set(0, 9);
		System.out.println(array.get(0));
		array.clear();
		System.out.println(array.isEmpty());
	
	}
}
