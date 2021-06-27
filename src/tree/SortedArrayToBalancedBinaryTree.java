package tree;

public class SortedArrayToBalancedBinaryTree {

  public static void main(String[] args) {
//    System.out.println(new SortedArrayToBalancedBinaryTree().sortedArrayToBST(1, 2, 3, 4, 5));
    System.out.println(new SortedArrayToBalancedBinaryTree().sortedArrayToBST(1, 2, 3, 4, 5, 6));
  }

  public TreeNode sortedArrayToBST(final int ...A) {
    return sortedArrayToBST(A, 0, A.length-1);
  }

  public TreeNode sortedArrayToBST(final int[] A, int s, int e) {
    if (s>e) {
      return null;
    }

    if (s==e) {
      return new TreeNode(A[s]);
    }

    int mid = ((e-s) % 2 == 0) ? ((e+s) / 2) : (((e+s)/2) + 1);
    TreeNode node = new TreeNode(A[mid]);
    node.left = sortedArrayToBST(A, s, mid-1);
    node.right = sortedArrayToBST(A, mid+1, e);
    return node;
  }
}
