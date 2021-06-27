package tree;

import java.util.Arrays;

public class SumOfAllRootToLeafPath {

  public static void main(String[] args) {
    System.out.println(new SumOfAllRootToLeafPath()
        .sumNumbers(TreeNode.buildTree(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1))));
  }

  long sum;
  public int sumNumbers(TreeNode A) {
    sum = 0;
    preorder(A, 0);
    return (int) sum;
  }

  public void preorder(TreeNode A, long num) {
    num = ((num*10)%1003 + A.val)%1003;

    if (A.left == null && A.right == null) { // leaf
      sum = (sum + num) % 1003;
      return;
    }

    if (A.left != null) preorder(A.left, num);
    if (A.right != null) preorder(A.right, num);
  }
}
