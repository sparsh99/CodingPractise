package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveHalfNodes {
  /*
      Half Nodes are nodes with only one child
   */

  public static void main(String[] args) {
    System.out.println(
        new RemoveHalfNodes()
            .solve(TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 1, 2, 3, -1, -1, -1, -1))))
    );
  }

  public TreeNode solve(TreeNode A) {
    if (A == null) {
      return null;
    }

    if (A.left == null && A.right == null) {
      return A;
    }

    if (A.left == null) {
      return solve(A.right);
    } else if (A.right == null) {
      return solve(A.left);
    }

    A.left = solve(A.left);
    A.right = solve(A.right);
    return A;
  }

}
