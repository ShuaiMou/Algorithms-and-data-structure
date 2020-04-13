package structure.tree;

import java.util.List;
import java.util.Random;

/**
 * @Auther: Saul
 * @Date: 13/4/20 17:09
 * @Description: the Randomized Treap.
 */
public class Treap<T extends Comparable<? super T>> implements Tree<T>{

    private TreapNode<T> root;

    @Override
    public boolean insert(T data) {
        if (data == null || contains(data)) return false;
        root = insert(root, data);
        return true;
    }

    private TreapNode insert(TreapNode subRoot, T data){

        return subRoot;
    }

    @Override
    public boolean delete(T data) {
        return false;
    }

    @Override
    public boolean update(T oldData, T newData) {
        return false;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public List<T> preOrderTraverse() {
        return null;
    }

    @Override
    public List<T> inOrderTraverse() {
        return null;
    }

    @Override
    public List<T> postOrderTraverse() {
        return null;
    }

    @Override
    public List<T> levelTraverse() {
        return null;
    }

    private static Random random=new Random();

    private class TreapNode<T>{
        T data;
        int priority;
        TreapNode<T> left;
        TreapNode<T> right;

        TreapNode(T data){
            this.data = data;
            this.priority = randomPriority();
        }

        @Override
        public String toString() {
            return "TreapNode{" +
                    "data=" + data +
                    ", priority=" + priority +
                    '}';
        }

        private int randomPriority(){
            return random.nextInt(Integer.MAX_VALUE);
        }
    }
}
