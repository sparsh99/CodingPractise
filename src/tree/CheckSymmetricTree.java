package tree;

import java.util.Arrays;

public class CheckSymmetricTree {

  public static void main(String[] args) {
    System.out.println(
        new CheckSymmetricTree().isSymmetric(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(7, 2, -1, 3, 5, -1, -1))
        )
    );

    System.out.println(
        new CheckSymmetricTree().isSymmetric(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(7, 2, 2, 3, 5, 5, 3))
        )
    );
  }

  public int isSymmetric(TreeNode A) {
    if (A == null) return 1;
    return isMatch(A.left, A.right) ? 1 : 0;
  }

  public boolean isMatch(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null || left.val != right.val) {
      return false;
    }

    return isMatch(left.left, right.right) && isMatch(left.right, right.left);
  }

}
