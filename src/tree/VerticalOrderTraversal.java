package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VerticalOrderTraversal {

  public static void main(String[] args) {
    System.out.println(
        new VerticalOrderTraversal().verticalOrderTraversal(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        )
    );

    System.out.println(
        new VerticalOrderTraversal().verticalOrderTraversal(
            TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(3709, 4465, 2668))
        )
    );

    System.out.println(
        new VerticalOrderTraversal().verticalOrderTraversal(
            null
        )
    );
  }

  /*
    Orders elements based on Level-Order.
 */
  Map<TreeNode, Integer> posMap;
  public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (A == null) {
      return ans;
    }

    posMap = new HashMap<>();
    verticalOrderTraversal(A, 0);

    Deque<TreeNode> dq = new LinkedList<>();
    dq.addFirst(A);

    // add nodes in vertical-position list based on level-order position.
    HashMap<Integer, ArrayList<Integer>> ansMap = new HashMap<>();
    int minPos = 0;
    int maxPos = 0;
    while(!dq.isEmpty()) {
      TreeNode node = dq.pollFirst();
      Integer pos = posMap.get(node);

      if (minPos > pos) {
        minPos = pos;
      } else if (maxPos < pos) {
        maxPos = pos;
      }

      if (!ansMap.containsKey(pos))
        ansMap.put(pos, new ArrayList<>());

      ansMap.get(pos).add(node.val);
      if (node.left != null) dq.addLast(node.left);
      if (node.right != null) dq.addLast(node.right);
    }

    for (int i=minPos; i<=maxPos; i++) {
      ans.add(ansMap.get(i));
    }

    return ans;
  }

  public void verticalOrderTraversal(TreeNode A, int pos) {
    if (A == null) {
      return;
    }
    // vertical position is based on distance from main root.
    posMap.put(A, pos);
    verticalOrderTraversal(A.left, pos - 1);
    verticalOrderTraversal(A.right, pos + 1);
  }

  /*
      Below solution orders elements based on Pre-Order.
   */
//  Map<Integer, ArrayList<Integer>> ansMap;
//  public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
//    ansMap = new HashMap<>();
//    verticalOrderTraversal(A, 0);
//
//    ArrayList<Integer> posArr = new ArrayList<>(ansMap.keySet());
//    Collections.sort(posArr);
//    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//
//    for (int key : posArr) {
//      ans.add(ansMap.get(key));
//    }
//
//    return ans;
//  }
//
//  public void verticalOrderTraversal(TreeNode A, int pos) {
//    if (A == null) {
//      return;
//    }
//
//    if (!ansMap.containsKey(pos)) {
//      ansMap.put(pos, new ArrayList<>());
//    }
//
//    ansMap.get(pos).add(A.val);
//    verticalOrderTraversal(A.left, pos - 1);
//    verticalOrderTraversal(A.right, pos + 1);
//  }
}
