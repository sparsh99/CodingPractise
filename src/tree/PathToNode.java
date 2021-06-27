package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PathToNode {

  public static void main(String[] args) {
    System.out.println(new PathToNode().solve(
        TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 1, 2, 3, -1, -1, -1, -1))), 3
    ));

    System.out.println(new PathToNode().solve(
        TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 1, 2, 3, -1, -1, -1, -1))), 10
    ));
  }

  public ArrayList<Integer> solve(TreeNode A, int B) {
    if (A == null) {
      return new ArrayList<Integer>();
    }

    ArrayList<Integer> ans =
        new ArrayList<Integer>(Arrays.asList(A.val));
    if (A.val == B) {
      return ans;
    }

    ArrayList<Integer> leftAns = solve(A.left, B);
    if (!leftAns.isEmpty()) {
      ans.addAll(leftAns);
      return ans;
    }

    ArrayList<Integer> rightAns = solve(A.right, B);
    if (!rightAns.isEmpty()) {
      ans.addAll(rightAns);
      return ans;
    }

    return new ArrayList<Integer>();
  }
}
