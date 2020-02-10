package structure.hash;

import java.util.LinkedList;

import lombok.Getter;
import lombok.Setter;

public class MyHashMap<K,V> {
	private @Setter @Getter int key;
	private @Setter @Getter V value;
	private int m = 16 ;
	
	/**
	 * use separate chanining to store duplicated key
	 */
	LinkedList<V>[] array = new LinkedList[m];
	
	/**
	 * calculate the hash value of key,and return it
	 * 
	 * @param key
	 * @return
	 */
	public int hashing(K key){
		return key.hashCode() & (m-1);
	}
	
	/**
	 * put the (key, value) in the hash table
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		this.key = hashing(key);
		if (array[this.key] == null) {
			LinkedList<V> list = new LinkedList<>();
			list.add(value);
			array[this.key] = list;
		}else {
			array[this.key].add(value);
		}
		
	}
	
	
}
