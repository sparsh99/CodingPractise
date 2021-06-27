package tree;

import java.util.Arrays;

public class PopulateNextTreeNodePointer {

  public static void main(String[] args) {
    TreeLinkNode A = TreeLinkNode.buildTreeFromCompleteLevelOrder(
        Arrays.asList(7, 2, -1, 3, 5, -1, -1));
    new PopulateNextTreeNodePointer().connect(A);
    TreeLinkNode.printLevelOrder(A);
  }

  public void connect(TreeLinkNode A) {
    TreeLinkNode parent = A;
    while (parent != null) {
      TreeLinkNode childPrev = null;
      TreeLinkNode firstChild = null;
      while (parent != null) {
        if (parent.left == null && parent.right == null) {
          // do nothing
        } else if (parent.right == null) {
          if (childPrev != null) childPrev.next = parent.left;
          childPrev = parent.left;
          if (firstChild == null) firstChild = parent.left;
        } else if (parent.left == null) {
          if (childPrev != null) childPrev.next = parent.right;
          childPrev = parent.right;
          if (firstChild == null) firstChild = parent.right;
        } else {
          if (childPrev != null) childPrev.next = parent.left;
          parent.left.next = parent.right;
          childPrev = parent.right;
          if (firstChild == null) firstChild = parent.left;
        }

        parent = parent.next;
      }

      parent = firstChild;
    }
  }
}
