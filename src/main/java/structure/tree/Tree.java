package structure.tree;

import java.util.List;

/**
 * @Auther: Saul
 * @Date: 13/4/20 17:11
 * @Description:
 */
public interface Tree<T extends Comparable<? super T>> {
    boolean insert(T data);
    boolean delete(T data);
    boolean update(T oldData, T newData);
    boolean contains(T data);
    List<T> preOrderTraverse();
    List<T> inOrderTraverse();
    List<T> postOrderTraverse();
    List<T> levelTraverse();

}
