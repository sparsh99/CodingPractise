package math;

public class FindNextSmallestNumber {

  public static void main(String[] args) {
    System.out.println(new FindNextSmallestNumber().solve("23141532"));
    System.out.println(new FindNextSmallestNumber().solve("1234566"));
    System.out.println(new FindNextSmallestNumber().solve("6543321"));
    System.out.println(new FindNextSmallestNumber().solve("2"));
  }

  public String solve(String A) {
    // iterate from right to left till values are increasing.
    // the first dip number is to swapped with next bigger digit on its right
    // then sort ascending right digits small to large

    // 23141532
    // 1234566
    // 6543321

    int dipPosition = A.length()-1;
    for (int i=A.length() - 2; i>=0 ; i--) {
      if ((int) A.charAt(i + 1) > (int) A.charAt(i)) {
        dipPosition = i;
        break;
      } else if (i == 0) {
        dipPosition = -1;
      }
    }

    if (A.length() == 1 || dipPosition == -1) {
      return "-1";
    }

    int swapPosition = -1;
    for (int i=A.length()-1; i>=dipPosition+1; i--) {
      if (A.charAt(dipPosition) < A.charAt(i)) {
        swapPosition = i;
        break;
      }
    }

    return A.substring(0, dipPosition) + A.charAt(swapPosition) +
        new StringBuilder(
            A.substring(dipPosition + 1, swapPosition)
                + A.charAt(dipPosition)
                + A.substring(swapPosition + 1)
        ).reverse();
  }
}
