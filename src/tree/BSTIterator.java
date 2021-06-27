package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BSTIterator {

  public static void main(String[] args) {
    print(new BSTIterator(TreeNode.buildTree(new ArrayList<>(
        Arrays.asList(7, 2, 1, 3, -1, -1, -1, -1)))));

  }

  private static void print(BSTIterator iterator) {
    while(iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
  }

  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    this.stack = new Stack<>();
    while(root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pop();
    if (node.right != null) {
      TreeNode node1 = node.right;
      while(node1 != null) {
        stack.push(node1);
        node1 = node1.left;
      }
    }
    return node.val;
  }

  /**
   * Your Solution will be called like this:
   * Solution i = new Solution(root);
   * while (i.hasNext()) System.out.print(i.next());
   */
}
