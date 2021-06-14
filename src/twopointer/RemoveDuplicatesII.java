package twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesII {

  public static void main(String[] args) {
    System.out.println(
        new RemoveDuplicatesII().removeDuplicates(
            new ArrayList<>(Arrays.asList(
                1,1,1,2
            ))
        )
    );
  }

  public int removeDuplicates(ArrayList<Integer> a) {
    int i=0;
    int start = 0;
    int prev = 0;
    while(start < a.size()) {
      if (i < a.size() && (start == i || a.get(i).equals(a.get(i-1)))) {
        i++;
      } else {
        if (start < a.size()-1 && a.get(start).equals(a.get(start+1))) {
          a.set(prev, a.get(start));
          a.set(prev+1, a.get(start));
          prev += 2;
        } else {
          a.set(prev, a.get(start));
          prev += 1;
        }

        start=i;
        i++;
      }
    }

    for (int j=a.size()-1; j>=prev; j--) {
      a.remove(j);
    }

    return a.size();
  }
}
