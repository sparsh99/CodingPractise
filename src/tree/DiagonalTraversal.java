package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DiagonalTraversal {

  public static void main(String[] args) {
    System.out.println(
        new DiagonalTraversal().solve(TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(
            1, 15, 2
        )))
    );
    System.out.println(
        Arrays.toString(new DiagonalTraversal()
            .solveQueue(TreeNode.buildTreeFromCompleteLevelOrder(Arrays.asList(
                1, 15, 2
            ))))
    );
  }

  Map<Integer, List<Integer>> ansMap;
  int minPos;
  int maxPos;
  public ArrayList<Integer> solve(TreeNode A) {
    ansMap = new HashMap<>();
    minPos = 0;
    maxPos = 0;
    solve(A, 0, 0);

    ArrayList<Integer> ans = new ArrayList<>();
    for (int i=minPos; i<=maxPos; i++) {
      if (!ansMap.containsKey(i)) {
        continue;
      }

      ans.addAll(ansMap.get(i));
    }

    return ans;
  }

  public void solve(TreeNode A, int depth, int pos) {
    if (A==null) return;

    int key = depth-pos;
    if (!ansMap.containsKey(key)) {
      ansMap.put(key, new ArrayList<>());
      if (minPos > key) minPos = key;
      if (maxPos < key) maxPos = key;
    }

    ansMap.get(key).add(A.val);
    solve(A.left, depth+1, pos-1);
    solve(A.right, depth+1, pos+1);
  }

  /*
      Solve using only queue, no recursion
      It can be done by creating a queue which orders element as required in ans.
      This works as follows - after any layer, next layer will be the list of left children
        of elements in previous layer. right children will be in same layer as parent.
      So, at any node at head of queue we iterate right till end for same layer and add to answer.
      Then, we iterate through same right elements again and add left child to queue for future
        iteration in next layer.
   */
  public int[] solveQueue(TreeNode A) {
    Queue<TreeNode> q = new LinkedList<>();

    q.add(A);
    ArrayList<Integer> sol = new ArrayList<>();
    while(!q.isEmpty()){
      TreeNode tn = q.poll();
      TreeNode temp = tn;
      sol.add(tn.val);
      while(tn.right != null && tn.right.val != -1){
        sol.add(tn.right.val);
        tn = tn.right;
      }
      while(temp != null){
        if(temp.left != null){
          q.add(temp.left);
        }
        temp = temp.right;
      }
    }
    int[] arr = new int[sol.size()];
    for(int i=0; i<sol.size(); i++){
      arr[i] = sol.get(i);
    }
    return arr;

  }
}
