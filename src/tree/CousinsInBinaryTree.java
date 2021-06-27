package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class CousinsInBinaryTree {

  public static void main(String[] args) {
    System.out.println(
        new CousinsInBinaryTree().solve(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 5)
    );

    System.out.println(
        new CousinsInBinaryTree().solve(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 2, 3, 4, 5, -1, 6)), 1)
    );
  }

  public ArrayList<Integer> solve(TreeNode A, int B) {
    ArrayList<TreeNode> parent = new ArrayList<>();
    parent.add(A);
    while (true) {
      ArrayList<TreeNode> current = new ArrayList<>();
      boolean bFound = false;
      for (TreeNode node: parent) {
        if ((node.left != null && node.left.val == B)
            || (node.right != null && node.right.val == B)) {
          bFound = true;
          continue;
        }

        if (node.left != null) current.add(node.left);
        if (node.right != null) current.add(node.right);
      }

      parent = current;
      if (bFound || current.isEmpty()) {
        break;
      }
    }

    ArrayList<Integer> ans = new ArrayList<Integer> ();
    for (TreeNode node: parent) {
      ans.add(node.val);
    }

    return ans;
  }

  TreeNode bp;
  Integer depth;
  ArrayList<Integer> ans;

  public ArrayList<Integer> solveRecursion(TreeNode A, int B) {
    bp = null;
    depth = null;
    ans = new ArrayList<Integer>();
    findBParent(A, B, 0);
    if (bp == null) return ans;
    findBCousin(A, null, 0);
    return ans;
  }

  public void findBParent(TreeNode A, int B, int currDepth) {
    if (A==null) return;

    if (A.left != null && A.left.val==B) {
      bp = A;
      depth = currDepth + 1;
      return;
    }

    if (A.right != null && A.right.val==B) {
      bp = A;
      depth = currDepth + 1;
      return;
    }

    findBParent(A.left, B, currDepth+1);
    if (bp != null) return;

    findBParent(A.right, B, currDepth+1);
  }

  public void findBCousin(TreeNode A, TreeNode parent, int currDepth) {
    if (currDepth == depth && parent != bp) {
      if (A != null) ans.add(A.val);
      return;
    } else if (currDepth == depth) {
      return;
    }

    findBCousin(A.left, A, currDepth+1);
    findBCousin(A.right, A, currDepth+1);
  }
}
