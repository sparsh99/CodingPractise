package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildTreeFromPreAndInOrder {

  public static void main(String[] args) {
    System.out.println(new BuildTreeFromPreAndInOrder().buildTree(
        new ArrayList<>(Arrays.asList(2, 1, 6, 5, 3, 4)),
        new ArrayList<>(Arrays.asList(5, 6, 1, 2, 3, 4))
    ).val);
  }

  public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
    return buildTree(pre, in, 0, pre.size()-1, 0, in.size()-1);
  }

  public TreeNode buildTree(
      ArrayList<Integer> pre, ArrayList<Integer> in,
      int preS, int preE, int inS, int inE
  ) {
    if (preS > preE) {
      return null;
    }

    if (preS == preE) {
      return new TreeNode(pre.get(preS));
    }

    int root = pre.get(preS);
    TreeNode node = new TreeNode(root);

    // find root in inorder range
    // this could be improved by keeping a map of each element to pos
    int inRootPos = -1;
    for (int i=inS; i<=inE; i++) {
      if (in.get(i) == root) {
        inRootPos = i;
        break;
      }
    }

    if (inRootPos > inS) {
      int leftCount = inRootPos - inS;
      node.left = buildTree(pre, in, preS+1, preS+leftCount, inS, inRootPos-1);
      node.right = buildTree(pre, in, preS+leftCount+1, preE, inRootPos+1, inE);
    } else {
      node.right = buildTree(pre, in, preS+1, preE, inRootPos+1, inE);
    }

    return node;
  }

}
