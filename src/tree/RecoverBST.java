package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecoverBST {

  public static void main(String[] args) {
    System.out.println(new RecoverBST().recoverTree(
        TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 1, 2, 3, -1, -1, -1, -1)))));
    System.out.println(new RecoverBST().recoverTree(
        TreeNode.buildTree(new ArrayList<>(Arrays.asList(7, 2, 3, 1, -1, -1, -1, -1)))));
  }

  private List<Integer> firstDecrease;
  private List<Integer> secondDecrease;
  private int prev = -1;

  public ArrayList<Integer> recoverTree(TreeNode A) {
    firstDecrease = new ArrayList<>();
    secondDecrease = new ArrayList<>();
    inOrderTraverse(A);

    if (secondDecrease.isEmpty()) {
      Collections.sort(firstDecrease);
      return new ArrayList<>(firstDecrease);
    }

    return new ArrayList<>(
        Arrays.asList(secondDecrease.get(1), firstDecrease.get(0)));
  }

  public void inOrderTraverse(TreeNode A) {
    if (A == null) {
      return;
    }

    inOrderTraverse(A.left);

    if (prev > A.val) {
      if (firstDecrease.isEmpty()) {
        firstDecrease.add(prev);
        firstDecrease.add(A.val);
      } else {
        secondDecrease.add(prev);
        secondDecrease.add(A.val);
      }
    }

    prev = A.val;
    inOrderTraverse(A.right);
  }
}
