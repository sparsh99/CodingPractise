package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ZigZagLevelOrder {

  public static void main(String[] args) {
    System.out.println(
        new ZigZagLevelOrder()
            .zigzagLevelOrder(TreeNode.buildTreeFromCompleteLevelOrder(
                new ArrayList<>(Arrays.asList(7, 2, 1, 3, -1, -1, 4))))
    );
    System.out.println(
        new ZigZagLevelOrder()
            .zigzagLevelOrder(TreeNode.buildTreeFromCompleteLevelOrder(
                new ArrayList<>(Arrays.asList(7, 2, 1, 3, 4, 5, 6))))
    );
  }

  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    ArrayList<TreeNode> current = new ArrayList<>();
    current.add(A);
    ans.add(new ArrayList<Integer>(Arrays.asList(A.val)));
    int level=1;
    while (!current.isEmpty()) {
      ArrayList<Integer> row = new ArrayList<>();
      ArrayList<TreeNode> next = new ArrayList<>();
      for (TreeNode p : current) {
        if (p.left != null) {
          row.add(p.left.val);
          next.add(p.left);
        }
        if (p.right != null) {
          row.add(p.right.val);
          next.add(p.right);
        }
      }

      current = next;
      if (!row.isEmpty()) {
        if (level%2 == 0) ans.add(row);
        else {
          Collections.reverse(row);
          ans.add(row);
        }
      }
      level++;
    }

    return ans;
  }
}
