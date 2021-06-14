package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxNonNegSubArr {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    int[] arr = new int[n];
//    for (int i=0; i<n; i++) {
//      arr[i] = scanner.nextInt();
//    }

    int[] arr = {1, 2, 5, -7, 2, 3};
    int[] arr1 = {10, -1, 2, 3, -4, 100};
    Arrays.stream(new MaxNonNegSubArr().maxset(arr)).forEach(System.out::println);
    Arrays.stream(new MaxNonNegSubArr().maxset(arr1)).forEach(System.out::println);
  }

  public int[] maxset(int[] A) {
    int start=-1;
    int end=-1;
    int max_start = -1;
    int max_end = -1;
    long max_sum = 0;
    long sum = 0;

    for (int i=0;i<A.length; i++) {
      if (A[i] >= 0 && start == -1) {
        start = i;
      }

      if (A[i] >= 0) {
        end = i;
        sum += A[i];
      }

      if (A[i] < 0 || (A[i] > 0 && i==A.length-1)) {
        if (max_start == -1 || sum > max_sum
            || (sum == max_sum && end-start > max_end-max_start)) {
          max_start = start;
          max_end = end;
          max_sum = sum;
        }

        start = -1;
        end = -1;
        sum = 0;
      }
    }

    int[] ans = new int[0];
    if (max_start != -1) {
      ans = new int[max_end-max_start+1];
      for (int i=0; i<=max_end-max_start; i++) {
        ans[i] = A[max_start+i];
      }
    }

    return ans;
  }
}
