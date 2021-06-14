package twopointer;

import java.util.List;

public class ArrayThreePointer {
  public static void main(String[] args) {

  }

  public int minimizeTwoPoint(
      final List<Integer> A, final List<Integer> B, final List<Integer> C
  ) {
    int minDiff = Integer.MAX_VALUE;
    for (int i=0; i<A.size(); i++) {
      int pt1=0;
      int pt2=0;
      while(pt1<B.size() || pt2<C.size()) {
        int diff = Math.max(
            Math.abs(B.get(pt1) - A.get(i)),
            Math.max(
                Math.abs(B.get(pt1) - C.get(pt2)),
                Math.abs(A.get(i) - C.get(pt2))
            )
        );
        if (diff < minDiff) {
          minDiff = diff;
        }

        if (pt1 == B.size() - 1 && pt2 == C.size() - 1) {
          pt1++;
          pt2++;
        } else if (pt1 == B.size() - 1) {
          pt2++;
        } else if (pt2 == C.size() - 1) {
          pt1++;
        } else if (B.get(pt1) < C.get(pt2)) {
          pt1++;
        } else {
          pt2++;
        }
      }
    }

    return minDiff;
  }
  public int minimize(
      final List<Integer> A, final List<Integer> B, final List<Integer> C) {
    int pnt1 = 0;
    int pnt2 = 0;
    int pnt3 = 0;
    int minDiff = Integer.MAX_VALUE;

    while(pnt1 < A.size() && pnt2 < B.size() && pnt3 < C.size()) {
      int diff = Math.max(
          Math.abs(A.get(pnt1) - B.get(pnt2)),
          Math.max(
              Math.abs(A.get(pnt1) - C.get(pnt3)),
              Math.abs(C.get(pnt3) - B.get(pnt2))
          )
      );
      if (diff < minDiff) {
        minDiff = diff;
      }

      // See minimizeBadCode
      // since we are incrementing only the smallest element, we don't need to
      // iterate larger array if any of the other array is completely iterated.
      // Think this, if larger array had any smaller element it would have been incremented
      // So, it means remaining array only has larger elemnts and moving them forward would only
      // increase max_diff .
      // Lets say config is
      //    |  | A | B [smallest is from completed arr] - clearly x places increases gap with smallest
      //    or | A | B | C [mid is from completed arr] - Case not possible, as smallest
      //                      element array will iterated first before any arr is completed
      if (A.get(pnt1) <= B.get(pnt2) && A.get(pnt1) <= C.get(pnt3)) {
        pnt1++;
      } else if (B.get(pnt2) < A.get(pnt1) && B.get(pnt2) < C.get(pnt3)) {
        pnt2++;
      } else {
        pnt3++;
      }
    }

    return minDiff;
  }

  public int minimizeBadCode(
      final List<Integer> A, final List<Integer> B, final List<Integer> C) {
    int pnt1 = 0;
    int pnt2 = 0;
    int pnt3 = 0;
    int minDiff = 0;

    while(pnt1 < A.size() || pnt2 < B.size() || pnt3 < C.size()) {
      int diff = Math.max(
          Math.abs(A.get(pnt1) - B.get(pnt2)),
          Math.max(
              Math.abs(A.get(pnt1) - C.get(pnt3)),
              Math.abs(C.get(pnt3) - B.get(pnt2))
          )
      );
      if (diff < minDiff) {
        minDiff = diff;
      }

      if (pnt1 < A.size() - 1 && pnt2 < B.size() - 1 && pnt3 < C.size() - 1) {
        if (A.get(pnt1) <= B.get(pnt2) && A.get(pnt1) <= B.get(pnt3)) {
          pnt1++;
        } else if (B.get(pnt2) < A.get(pnt1) && B.get(pnt2) < C.get(pnt3)) {
          pnt2++;
        } else {
          pnt3++;
        }
      } else if (pnt1 < A.size() - 1 && pnt2 < B.size() - 1) {
        if (A.get(pnt1) < B.get(pnt2)) {
          pnt1++;
        } else {
          pnt2++;
        }
      } else if (pnt2 < B.size() - 1 && pnt3 < C.size() - 1) {
        if (C.get(pnt3) < B.get(pnt2)) {
          pnt3++;
        } else {
          pnt2++;
        }
      } else if (pnt1 < A.size() - 1 && pnt3 < C.size() - 1) {
        if (C.get(pnt3) < A.get(pnt1)) {
          pnt3++;
        } else {
          pnt1++;
        }
      } else {
        pnt1++;
        pnt2++;
        pnt3++;
      }
    }

    return minDiff;
  }
}
