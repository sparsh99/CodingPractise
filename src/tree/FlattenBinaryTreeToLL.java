package tree;

import java.util.Arrays;

public class FlattenBinaryTreeToLL {

  public static void main(String[] args) {
    TreeNode.printLevelOrder(
        new FlattenBinaryTreeToLL().flatten(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 2, 3)))
    );
  }

  public TreeNode flatten(TreeNode a) {
    if (a == null) return a;

    TreeNode left = flatten(a.left);
    TreeNode right = flatten(a.right);
    a.left = null;
    if (left != null) {
      TreeNode leftEnd = left;
      while (leftEnd != null) {
        if (leftEnd.right == null) {
          break;
        }

        leftEnd = leftEnd.right;
      }

      a.right = left;
      leftEnd.right = right;
    } else {
      a.right = right;
    }

    return a;
  }

}
