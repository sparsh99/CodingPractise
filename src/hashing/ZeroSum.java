package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSum {

  public static void main(String[] args) {
//    System.out.println(new ZeroSum().lszero(new ArrayList<>(
//        Arrays.asList(1 ,2 ,-2 ,4 ,-4)
//    )));
    System.out.println(new ZeroSum().lszero(new ArrayList<>(
        Arrays.asList(1, 2, -3, 3)
    )));
  }

  public ArrayList<Integer> lszero(ArrayList<Integer> A) {
    Map<Integer, Integer> sumMap = new HashMap<>();
    int sum = 0;
    int max_start = -1;
    int max_end = -1;
    for (int i=0; i<A.size(); i++) {
      sum += A.get(i);
      if (sum == 0) { // this can be removed by adding a fake entry in sumMap before hand for sum 0
        max_start = 0;
        max_end = i;
      } else if (sumMap.containsKey(sum)
          && (max_end == -1 || i-sumMap.get(sum)-1 > max_end-max_start)) {
        max_start = sumMap.get(sum)+1;
        max_end = i;
      } else if (!sumMap.containsKey(sum)) {
        sumMap.put(sum, i);
      }
    }

    if (max_start == -1) {
      return new ArrayList<Integer>();
    }

    return new ArrayList<>(A.subList(max_start, max_end+1));
  }
}
