package tree;

import java.util.Arrays;

public class InvertTree {

  public static void main(String[] args) {
    System.out.println(
        new InvertTree().invertTree(TreeNode.buildTree(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1)))
    );
  }

  public TreeNode invertTree(TreeNode A) {
    if (A == null) {
      return A;
    }

    TreeNode left = invertTree(A.left);
    A.left = invertTree(A.right);
    A.right = left;

    return A;
  }
}
