package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PreorderTraversalUsingStack {

  public static void main(String[] args) {
    System.out.println(new PreorderTraversalUsingStack()
        .preorderTraversal(TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 15, 2))));
  }

  public ArrayList<Integer> preorderTraversal(TreeNode A) {
    Stack<TreeNode> s = new Stack<>();
    s.push(A);
    ArrayList<Integer> ans = new ArrayList<Integer>();
    while(!s.isEmpty()) {
      TreeNode node = s.pop();
      ans.add(node.val);
      if (node.right != null) s.push(node.right);
      if (node.left != null) s.push(node.left);
    }

    return ans;
  }

}
