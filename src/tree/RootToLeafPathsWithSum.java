package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class RootToLeafPathsWithSum {

  public static void main(String[] args) {
    System.out.println(new RootToLeafPathsWithSum()
        .pathSum(TreeNode.buildTreeFromCompleteLevelOrder(
            Arrays.asList(7, 1, 2, 3, 2, 2, 3)), 11));
  }
  public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    pathRecursive(A, 0, B, new ArrayList<>(), ans);
    return ans;
  }

  public void pathRecursive(
      TreeNode A, int currSum, int sum,
      ArrayList<Integer> curr,
      ArrayList<ArrayList<Integer>> ans
  ) {
    if (A==null) {
      return;
    }

    curr.add(A.val);
    currSum+=A.val;
    if (A.left == null && A.right == null) {
      if (currSum == sum) ans.add(new ArrayList<>(curr));
    } else {
      pathRecursive(A.left, currSum, sum, curr, ans);
      pathRecursive(A.right, currSum, sum, curr, ans);
    }
    curr.remove(curr.size()-1);
  }
}
