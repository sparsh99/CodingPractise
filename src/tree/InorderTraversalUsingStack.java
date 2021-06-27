package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class InorderTraversalUsingStack {

  public static void main(String[] args) {
    System.out.println(
        new InorderTraversalUsingStack().inorderTraversal(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 15, 2))));
  }

  public ArrayList<Integer> inorderTraversal(TreeNode A) {
    HashMap<TreeNode, Boolean> visitedNode = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<Integer>();
    Stack<TreeNode> s = new Stack<>();
    s.push(A);
    while(!s.isEmpty()) {
      TreeNode node = s.peek();
      if (node.left != null && !visitedNode.containsKey(node.left)) {
        s.push(node.left);
      } else {
        s.pop();
        ans.add(node.val);
        visitedNode.put(node, true);
        if (node.right != null) s.push(node.right);
      }
    }
    return ans;
  }
}
