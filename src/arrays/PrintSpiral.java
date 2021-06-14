package arrays;

import java.util.Scanner;

public class PrintSpiral {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows = scanner.nextInt();
    int cols = scanner.nextInt();
    scanner.nextLine();

    int[][] arr = new int[rows][cols];
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        arr[i][j] = scanner.nextInt();
      }

      scanner.nextLine();
    }

    int[] ans = new PrintSpiral().spiralOrder(arr);
//    for (int i=0; i<ans.length; i++) {
//      System.out.println(ans[i]);
//    }
  }

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int[] spiralOrder(final int[][] A) {
    // layer
    //  i=layer j=layer to m-layer-1 , i=layer+1 to n-layer-1 and j = m-layer-1
    //  i=n-layer-1, j=m-layer-2 to layer, i= n-layer-2 to layer+1, j=layer

    int n = A.length;
    int m = A[0].length;
    int[] ans = new int[n*m];
    int j=0;
    int layerMax = Math.min(m, n);
    layerMax = (layerMax%2 == 0) ? layerMax/2 - 1 : layerMax/2;
    for (int layer=0; layer<=layerMax; layer++) {
      for(int i=layer; i<m-layer; i++) {
        System.out.println(A[layer][i]);
        ans[j] = A[layer][i];
        j++;
      }

      for(int i=layer+1; i<n-layer; i++) {
        System.out.println(A[i][m-layer-1]);
        ans[j] = A[i][m-layer-1];
        j++;
      }

      if (n-layer-1 != layer)
        for(int i=m-layer-2; i>=layer; i--) {
          System.out.println(A[n-layer-1][i]);
          ans[j] = A[n-layer-1][i];
          j++;
        }

      if (m-layer-1 != layer)
        for(int i=n-layer-2; i>=layer+1; i--) {
          System.out.println(A[i][layer]);
          ans[j] = A[i][layer];
          j++;
        }
    }

    return ans;
  }

}
