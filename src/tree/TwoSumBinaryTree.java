package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TwoSumBinaryTree {

  public static void main(String[] args) {
    System.out.println(new TwoSumBinaryTree().t2Sum(
        TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1))), 5));
    System.out.println(new TwoSumBinaryTree().t2Sum(
        TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1))), 7));
  }

  TreeNode head = null;
  TreeNode tail = null;

  public int t2Sum(TreeNode A, int B) {
    convertToLL(A);
    while(head != tail) {
      if (head.val + tail.val == B) {
        return 1;
      }

      if (head.val + tail.val < B) {
        head = head.right;
      } else {
        tail = tail.left;
      }
    }

    return 0;
  }

  public void convertToLL(TreeNode A) {
    if (A == null) {
      return;
    }

    convertToLL(A.left);

    TreeNode right = A.right;
    if (head == null) {
      head = A;
      tail = A;
      A.left = null;
      A.right = null;
    } else {
      tail.right = A;
      A.left = tail;
      A.right = null;
      tail = A;
    }

    convertToLL(right);
  }

  public int t2SumStack(TreeNode A, int B) {
    Stack<TreeNode> sLeft = new Stack<TreeNode>();
    Stack<TreeNode> sRight = new Stack<TreeNode>();

    TreeNode root = A;
    while (root != null) {
      sLeft.push(root);
      root = root.left;
    }
    if (sLeft.peek().val > B) return 0;
    root = A ;
    boolean found = false;

    // only store values in sRight till the number nearest to B;
    while (!found) {
      sRight.push(root);
      if (B == root.val) {
        found = true;
      }
      if (B>root.val){
        if (root.right == null) {
          found = true;
          continue;
        }
        root = root.right;
      } else {
        if (root.left == null) {
          found = true;
          continue;
        }
        root = root.left;
      }
    }



    while (!sLeft.isEmpty() && !sRight.isEmpty()){
      TreeNode l = sLeft.peek();
      TreeNode r = sRight.peek();
      if (l.val > r.val) {
        return 0;
      }
      if (l == r) return 0;
      if (l.val + r.val == B) return 1;
      if (l.val + r.val < B) {
        sLeft.pop();
        if (l.right != null) {
          root = l.right;
          while (root != null) {
            sLeft.push (root);
            root = root.left;
          }
        }
      } else {
        sRight.pop();
        if (r.left != null) {
          root = r.left;
          while (root != null){
            sRight.push(root);
            root = root.right;
          }
        }
      }

    }

    return 0;
  }
}
