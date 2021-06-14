package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
  /*
      Recursion Search is more optimal than two iteration loop, because there are
      common path for both.
   */

  public static void main(String[] args) {
    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            8
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            7
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            5
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            10
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            9
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            2
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)),
            14
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList()),
            14
        )
    );

    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(1)),
            1
        )
    );
    System.out.println(
        new SearchRange().searchRangeRecursion(
            new ArrayList<>(Arrays.asList(2)),
            1
        )
    );
  }

  public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
    int left = 0;
    int right = A.size()-1;
    int bleft = -1;
    int bright = -1;
    while(left <= right) {
      int mid = left + (right-left)/2;
      if (A.get(mid)==B) {
        if (mid>0 && A.get(mid-1).equals(A.get(mid))) {
          right = mid-1;
        } else {
          bleft = mid;
          break;
        }
      } else if (A.get(mid) < B) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }

    left = 0;
    right = A.size()-1;
    while(left <= right) {
      int mid = left + (right-left)/2;
      if (A.get(mid)==B) {
        if (mid<A.size()-1 && A.get(mid+1).equals(A.get(mid))) {
          left = mid+1;
        } else {
          bright = mid;
          break;
        }
      } else if (A.get(mid) < B) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }


    ArrayList<Integer> ans = new ArrayList<Integer>();
    ans.add(bleft);
    ans.add(bright);
    return ans;
  }

  int bleft = -1;
  int bright = -1;
  public ArrayList<Integer> searchRangeRecursion(final List<Integer> A, int B) {
    bsRecursion(A, B, 0, A.size()-1);
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ans.add(bleft);
    ans.add(bright);
    return ans;
  }

  private void bsRecursion(
      final List<Integer> A, int B, int left, int right
  ) {
    if (left <= right) {
      int mid = left + (right-left)/2;
      if (A.get(mid) == B) {
        if (mid > 0 && A.get(mid-1)==B) {
          bsRecursion(A, B, left, mid-1);
        } else {
          bleft = mid;
        }

        if (mid < A.size()-1 && A.get(mid+1)==B) {
          bsRecursion(A, B, mid+1, right);
        } else {
          bright = mid;
        }
      } else if (A.get(mid) > B) {
        bsRecursion(A, B, left, mid-1);
      } else {
        bsRecursion(A, B, mid+1, right);
      }
    }
  }
}
