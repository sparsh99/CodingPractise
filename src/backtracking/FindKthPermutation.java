package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class FindKthPermutation {

  public static void main(String[] args) {
    System.out.println(new FindKthPermutation().getPermutation(3, 4));
  }

  public String getPermutation(int n, int k) {
    int idx = 1;
    for (  idx = 1; idx <= n;idx++) {
      if (fact(idx) >= k) break;
    }
    StringBuilder ans = new StringBuilder();
    for( int i = 1; i <=n-idx;i++) {
      ans.append(i);
    }

    ArrayList<Integer> dat = new ArrayList<>(n);
    for( int i = 1; i <= idx;i++) {
      dat.add(i);
    }

    for( int i = 1; i <= idx;i++) {
      int t = (int) ((k-1)/fact(idx-i));
      ans.append(dat.get(t)+(n-idx));
      dat.remove(t);
      k = (int)(k-t*(fact(idx-i)));

    }

    return ans.toString();

  }
  public String getPermutation0(int n, int k) {
    int idx = k;
    StringBuilder ans = new StringBuilder();

    ArrayList<Integer> dat = new ArrayList<>(n);
    for( int i = 1; i <= n;i++) {
      dat.add(i);

    }


    for(int i = 1; i <= n;i++) {
      idx = (int)((k-1)/fact(n-i));
      ans.append(dat.get(idx));
      dat.remove(idx);
      k = (int)(k - idx*fact(n-i));

    }
    return ans.toString();
  }

  public long fact(int n) {
    int f = 1;
    for( int i = 1; i <= n;i++) {
      f *= i;
    }
    return f;
  }


  /*
      THIS IS NOT BACKTRACKING AND HENCE SUBOPTIMAL
   */
  public String getPermutationNotBacktracking(int A1, int B) {
    int A[] = new int[A1];
    for (int i=1; i<=A1; i++) {
      A[i-1] = i;
    }

    for (int i=0; i<B-1; i++) {
      int j=A1-1;
      while (A[j] < A[j-1]) {
        j--;
      }

      if (j==A1-1) {
        int t = A[j];
        A[j] = A[j-1];
        A[j-1] = t;
      } else {
        int k = j;
        while (k < A1 && A[k] > A[j-1]) {
          k++;
        }
        int t = A[j-1];
        A[j-1] = A[k-1];
        A[k-1] = t;
        Arrays.sort(A, j, A1);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<A1; i++) {
      sb.append(A[i]);
    }

    return sb.toString();
  }
}
