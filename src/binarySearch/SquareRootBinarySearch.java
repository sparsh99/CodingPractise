package binarySearch;

public class SquareRootBinarySearch {

  public static void main(String[] args) {
    System.out.println(new SquareRootBinarySearch().sqrt(10));
    System.out.println(new SquareRootBinarySearch().sqrt(930675566));
  }

  public int sqrt(int A) {
    if (A==0 || A==1) {
      return A;
    }

    int start = 1;
    int end = A/2;
    while(start<=end) {
      long mid = start + (end-start)/2;
      if (mid * mid == A) {
        return (int)mid;
      }

      if (mid * mid > A) {
        if ((mid-1) * (mid-1) < A) {
          return (int) (mid-1);
        } else {
          end = (int) mid-1;
        }
      } else {
        if ((mid+1) * (mid+1) > A) {
          return (int)mid;
        } else {
          start = (int)mid + 1;
        }
      }
    }

    return -1;
  }
}
