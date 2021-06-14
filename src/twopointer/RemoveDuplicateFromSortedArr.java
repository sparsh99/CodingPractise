package twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArr {

  public static void main(String[] args) {
//    System.out.println(
//        new RemoveDuplicateFromSortedArr().removeDuplicates(
//            new ArrayList<>(Arrays.asList(
//                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
//                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3
//            ))
//        )
//    );

    System.out.println(
        new RemoveDuplicateFromSortedArr().removeDuplicates(
            new ArrayList<>(Arrays.asList(
                0, 0, 0, 1, 1, 2, 2, 3
            ))
        )
    );
  }

  public int removeDuplicates(ArrayList<Integer> a) {
    int i=0;
    int prev=0;
    while(i<a.size()) {
      int start=i;
      while(i<a.size() && (i==start || a.get(i).equals(a.get(i-1)))) {
        i++;
      }
      a.set(prev, a.get(i-1));
      prev++;
    }

    for (int j=a.size()-1; j>=prev; j--) {
      a.remove(j);
    }

    return a.size();
  }
}
