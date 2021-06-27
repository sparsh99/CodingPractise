package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderHeapToTree {

  public static void main(String[] args) {
    System.out.println(new InorderHeapToTree()
        .buildTree(new ArrayList<>(Arrays.asList(1, 2, 3))).val);
  }

  public TreeNode buildTree(ArrayList<Integer> A) {
    return buildTree(A, 0, A.size()-1);
  }

  public TreeNode buildTree(ArrayList<Integer> A, int s, int e) {
    if (s > e) {
      return null;
    }

    if (s==e) {
      return new TreeNode(A.get(s));
    }

    int maxPos = s;
    for (int i=s; i<=e; i++) {
      if (A.get(i) > A.get(maxPos)) maxPos = i;
    }

    TreeNode node = new TreeNode(A.get(maxPos));
    node.left = buildTree(A, s, maxPos-1);
    node.right = buildTree(A, maxPos+1, e);
    return node;
  }
}
