package tree;

import java.util.Arrays;

public class MergeTwoBinaryTree {

  public static void main(String[] args) {
    TreeNode.printLevelOrder(new MergeTwoBinaryTree().solve(
        TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(7, 2, -1, 3, 5, -1, -1, -1)),
        TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1)))
    );
  }

  public TreeNode solve(TreeNode A, TreeNode B) {
    if (A == null && B == null) {
      return null;
    }

    if (A == null) {
      return B;
    } else if (B == null) {
      return A;
    } else {
      A.val += B.val;
      A.left = solve(A.left, B.left);
      A.right = solve(A.right, B.right);
      return A;
    }
  }

}
