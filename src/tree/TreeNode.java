package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  int depth;
  TreeNode(int x) {
    val = x;
    left=null;
    right=null;
    depth = -1;
  }

  public static TreeNode buildTree(List<Integer> A) {
    return buildTree(A, 0, A.size() - 1);
  }

  private static TreeNode buildTree(List<Integer> A, int s, int e) {
    if (s>e) {
      return null;
    }

    if (A.get(s) == -1) {
      return null;
    }

    TreeNode root = new TreeNode(A.get(s));
    root.left = buildTree(A, s+1, s + ((e-s)/2));
    root.right = buildTree(A, s + 1 + ((e-s)/2), e);
    return root;
  }

  public static TreeNode buildTreeFromCompleteLevelOrder(List<Integer> A) {
    // Expects an array to be complete tree with missing node represented as -1;
    List<TreeNode> B = new ArrayList<>();
    for (int i=0; i<A.size(); i++) {
      TreeNode node = null;
      if (A.get(i) != -1) node = new TreeNode(A.get(i));
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

  public static void printLevelOrder(TreeNode A) {
    LinkedList<TreeNode> q = new LinkedList<>();
    List<Integer> lO = new ArrayList<>();
    q.addFirst(A);
    while (!q.isEmpty()) {
      boolean nextLevelNeeded = false;
      int levelRange = q.size();
      for (int i=0; i<levelRange; i++) {
        TreeNode t = q.get(i);
        if (t != null && (t.left != null || t.right != null)) {
          nextLevelNeeded = true;
        }
      }

      for (int i=0; i<levelRange; i++) {
        TreeNode node = q.pollFirst();
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

//  private static TreeNode printTree(TreeNode root) {
//    Deque<TreeNode> q = new LinkedList<>();
//    q.push(root);
//    ArrayList<Integer> levelOrder = new ArrayList<>();
//    int height = 0;
//    while(!q.isEmpty()) {
//      TreeNode node2 = q.pollFirst();
//      if (node2.depth > height) {
//        height = node2.depth;
//      }
//
//      if (node2.left != null) {
//        node2.left.depth = node2.depth + 1;
//        q.push(node2.left);
//      }
//      if (node2.right != null) {
//        node2.right.depth = node2.depth + 1;
//        q.push(node2.right);
//      }
//
//      while(!q.isEmpty() && q.peek().depth == node2.depth) {
//        TreeNode node1 = q.pollFirst();
//        if (node1.left != null) {
//          node1.left.depth = node1.depth + 1;
//          q.push(node1.left);
//        }
//
//        if (node1.right != null) {
//          node1.right.depth = node1.depth + 1;
//          q.push(node1.right);
//        }
//      }
//    }
//  }
}
