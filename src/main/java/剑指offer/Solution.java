package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: Saul
 * @Date: 16/3/20 10:14 上午
 * @Description:
 */
public class Solution {

    // 1.二维数组中的查找
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) return false;
        int columns = array.length;
        int column = columns - 1;
        for (int[] ints : array) {
            for (; column >= 0; column--) {
                if (target == ints[column]) return true;
                if (target > ints[column]) {
                    break;
                }
            }
        }
        return false;
    }

    // 2.替换空格
    public String replaceSpace(StringBuffer str) {
        if(str == null) return "";
        String temp = str.toString();
        String s = temp.replaceAll(" ", "%20");
        return s;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
          this.val = val;
        }
    }
    
     //3.从尾到头输出链表
     public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
         ArrayList<Integer> result = new ArrayList<>();
         if (listNode == null) return result;
         Deque<Integer> stack = new LinkedList();
         stack.push(listNode.val);
         while (listNode.next != null){
             stack.push(listNode.next.val);
             listNode = listNode.next;
         }

         while (!stack.isEmpty()){
             result.add(stack.pop());
         }

         return result;
     }


    // Definition for binary tree
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // 4.重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode head = null;
        if(pre == null || in == null || pre.length == 0 || in.length == 0) return head;
        return construct(pre, in);
    }

    private TreeNode construct(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1 && in.length == 1){
            return root;
        }

        int rchildLchildBoundary = -1;
        for (int i = 0; i < in.length; i++){
            if (pre[0] == in[i]){
                rchildLchildBoundary = i;
                break;
            }
        }

        if (rchildLchildBoundary > 0){
            int[] lPre = Arrays.copyOfRange(pre, 1, rchildLchildBoundary + 1);
            int[] lIn = Arrays.copyOfRange(in, 0, rchildLchildBoundary);
            root.left = construct(lPre, lIn);
        }

        if (in.length - rchildLchildBoundary > 1){
            int[] rPre = Arrays.copyOfRange(pre,rchildLchildBoundary + 1, pre.length);
            int[] rIn = Arrays.copyOfRange(in, rchildLchildBoundary + 1, in.length);
            root.right = construct(rPre, rIn);
        }


        return root;
    }


    @Test
    public void test1(){
//        System.out.println(Find(16, new int[][]{{}}));

//        StringBuffer str = new StringBuffer("hello");
//        str.append(" ");
//        str.append("world");
//        System.out.println(replaceSpace(str));

//        ListNode listNode = new ListNode(5);
//        listNode.next = new  ListNode(53);
//        ArrayList<Integer> integers = printListFromTailToHead(listNode);
//        for (Integer ints : integers){
//            System.out.println(ints);
//        }
//
//        int[] pre = new int[]{1,2,4,7,3,5,6,8};
//        int[] in = new int[]{4,7,2,1,5,3,8,6};
//        TreeNode treeNode = reConstructBinaryTree(pre, in);
//        preOrder(treeNode);

        System.out.println( Math.pow(2, 3));

    }

    private void preOrder(TreeNode treeNode){
        if (treeNode != null) {
            System.out.print(treeNode.val + ", ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }
}
