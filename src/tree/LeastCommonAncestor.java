package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class LeastCommonAncestor {

  public static void main(String[] args) {
    System.out.println(
        new LeastCommonAncestor().lca(
            TreeNode.buildTreeFromCompleteLevelOrder(
                Arrays.asList(3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1, -1, -1)
            ),
            5, 1
        )
    );
    System.out.println(
        new LeastCommonAncestor().lca(
            TreeNode.buildTreeFromCompleteLevelOrder(
                Arrays.asList(3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1, -1, -1)
            ),
            6, 4
        )
    );
    System.out.println(
        new LeastCommonAncestor().lca(
            TreeNode.buildTreeFromCompleteLevelOrder(
                Arrays.asList(3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1, -1, -1)
            ),
            5, 4
        )
    );
    System.out.println(
        new LeastCommonAncestor().lca(
            TreeNode.buildTreeFromCompleteLevelOrder(
                Arrays.asList(3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1, -1, -1)
            ),
            5, 9
        )
    );
  }
  public int lca(TreeNode A, int B, int C) {

    ArrayList<Integer> pathC = new ArrayList<Integer>();
    ArrayList<Integer> pathB = new ArrayList<Integer>();

    boolean bfound = search(A, B, pathB);

    if (bfound && B==C) return B;

    boolean cfound = search(A, C, pathC);

    if (!bfound || !cfound) {
      return -1;
    }

    for (int i=0; i<pathB.size(); i++) {
      for (int j=0; j<pathC.size(); j++) {
        if (pathB.get(i).equals(pathC.get(j))) {
          return pathB.get(i);
        }
      }
    }

    return -1;
  }

  public boolean search(TreeNode A, int B, ArrayList<Integer> path) {
    if (A==null) {
      return false;
    }

    if (A.val == B) {
      path.add(A.val);
      return true;
    }

    boolean isFound = search(A.left, B, path);
    if (isFound) {
      path.add(A.val);
      return true;
    }

    isFound = search(A.right, B, path);
    if (isFound) {
      path.add(A.val);
      return true;
    }

    return false;
  }
}
