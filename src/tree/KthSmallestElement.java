package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class KthSmallestElement {

  public static void main(String[] args) {
    System.out.println(
        new KthSmallestElement().kthsmallest(
            TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1))), 2)
    );
  }

  int ans = -1;
  int cnt;

  public int kthsmallest(TreeNode A, int B) {
    ans = -1;
    cnt = 0;
    recurse(A, B);
    return ans;
  }

  public void recurse(TreeNode A, int B) {
    if (A == null) {
      return;
    }

    recurse(A.left, B);

    cnt++;
    if (cnt == B) {
      ans = A.val;
      return;
    }

    recurse(A.right, B);
  }
}
