package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArr {

  public static void main(String[] args) {
    System.out.println(
        new IntersectionOfTwoArr().intersect(
            new ArrayList<>(Arrays.asList(
                1, 2, 3, 3, 4, 5, 6
            )),
            new ArrayList<>(Arrays.asList(
                3, 3, 5
            ))
        )
    );
  }

  public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    int i=0;
    int j=0;
    while(i<A.size() && j<B.size()) {
      if (A.get(i) < B.get(j)) {
        i++;
      } else if (A.get(i) > B.get(j)) {
        j++;
      } else {
        int cnt = 0;
        int start_i = i;
        int start_j = j;
        while(i < A.size() && (i==start_i || A.get(i)==A.get(i-1))) {
          i++;
          cnt++;
        }

        int cnt1=0;
        while(j < B.size() && (j==start_j || B.get(j)==B.get(j-1))) {
          j++;
          cnt1++;
        }

        for(int k=0; k<Math.min(cnt, cnt1); k++) {
          ans.add(A.get(i-1));
        }
      }
    }

    return ans;
  }
}
