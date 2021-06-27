package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBalancedBinaryTree {

  public static void main(String[] args) {
    System.out.println(
        new CheckBalancedBinaryTree()
            .isBalanced(TreeNode.buildTree(
                new ArrayList<>(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1))))
    );
    System.out.println(
        new CheckBalancedBinaryTree()
            .isBalanced(TreeNode.buildTree(
                new ArrayList<>(Arrays.asList(7, 2, 1, 3, 4, 5, 6))))
    );
  }

  boolean isBalancedTree;
  public int isBalanced(TreeNode A) {
    isBalancedTree = true;
    checkDepth(A);
    return (isBalancedTree) ? 1 : 0;
  }

  public int checkDepth(TreeNode A) {
    if (A == null) {
      return 0;
    }

    int leftH = checkDepth(A.left);
    int rightH = checkDepth(A.right);
    if (Math.abs(leftH-rightH) > 1) {
      isBalancedTree = false;
    }

    return Math.max(leftH, rightH) + 1;
  }
}
