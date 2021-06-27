package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeLinkNode {
  int val;
  TreeLinkNode left;
  TreeLinkNode right;
  TreeLinkNode next;

  public TreeLinkNode(int x) {
    val = x;
    left=null;
    right=null;
  }

  public static TreeLinkNode buildTreeFromCompleteLevelOrder(List<Integer> A) {
    // Expects an array to be complete tree with missing node represented as -1;
    List<TreeLinkNode> B = new ArrayList<>();
    for (int i=0; i<A.size(); i++) {
      TreeLinkNode node = null;
      if (A.get(i) != -1) node = new TreeLinkNode(A.get(i));
      B.add(node);
    }

    for (int i=0; i<A.size(); i++) {
      if (B.get(i) == null)
        continue;
      B.get(i).left = (i*2 + 1 < A.size()) ? B.get(i*2 + 1) : null;
      B.get(i).right = (i*2 + 2 < A.size()) ? B.get(i*2 + 2) : null;
    }

    return B.get(0);
  }

  public static void printLevelOrder(TreeLinkNode A) {
    LinkedList<TreeLinkNode> q = new LinkedList<>();
    List<Integer> lO = new ArrayList<>();
    q.addFirst(A);
    while (!q.isEmpty()) {
      boolean nextLevelNeeded = false;
      int levelRange = q.size();
      for (int i=0; i<levelRange; i++) {
        TreeLinkNode t = q.get(i);
        if (t != null && (t.left != null || t.right != null)) {
          nextLevelNeeded = true;
        }
      }

      for (int i=0; i<levelRange; i++) {
        TreeLinkNode node = q.pollFirst();
        if (nextLevelNeeded) {
          if (node != null) {
            q.addLast(node.left);
            q.addLast(node.right);
          } else {
            q.addLast(null);
            q.addLast(null);
          }
        }
        lO.add((node == null) ? null : node.val);
      }
    }

    System.out.println(lO);
  }

}
