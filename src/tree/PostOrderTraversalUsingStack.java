package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class PostOrderTraversalUsingStack {

  public static void main(String[] args) {
    System.out.println(
        new PostOrderTraversalUsingStack().postorderTraversal(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 15, 2)))
    );
  }

  public ArrayList<Integer> postorderTraversal(TreeNode A) {
    HashMap<TreeNode, Boolean> visitedMap = new HashMap<>();
    Stack<TreeNode> s = new Stack<>();
    s.push(A);
    ArrayList<Integer> ans = new ArrayList<Integer>();
    while(!s.isEmpty()) {
      TreeNode node = s.peek();
      if ((node.left == null || visitedMap.get(node.left) == Boolean.TRUE)
          && (node.right == null || visitedMap.get(node.right) == Boolean.TRUE)
      ) {
        s.pop();
        visitedMap.put(node, true);
        ans.add(node.val);
      } else {
        if (node.right != null) s.push(node.right);
        if (node.left != null) s.push(node.left);
      }
    }

    return ans;
  }
}
