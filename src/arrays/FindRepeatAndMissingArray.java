package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRepeatAndMissingArray {

  public static void main(String[] args) {
    new FindRepeatAndMissingArray().repeatedNumber(Arrays.asList(
        3, 1, 2, 5, 3
    ));
  }

  public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

    int setXor = 0;
    int totalXor = 0;
    for (int i=0; i<A.size(); i++) {
      setXor ^= A.get(i);
      totalXor ^= (i+1);
    }

    int filterKey = (totalXor ^ setXor) & (~((totalXor ^ setXor) - 1));

    int bitOffXor = 0;
    int bitOnXor = 0;
    for (int i=0; i<A.size(); i++) {
      if ((A.get(i) & filterKey)== 0) bitOffXor ^= A.get(i);
      else bitOnXor ^= A.get(i);

      if (((i+1) & filterKey) == 0) bitOffXor ^= (i+1);
      else bitOnXor ^= (i+1);
    }

    for (int i=0; i<A.size(); i++) {
      if (A.get(i) == bitOnXor)
        return new ArrayList<Integer>(Arrays.asList(bitOnXor, bitOffXor));
    }

    return new ArrayList<Integer>(Arrays.asList(bitOffXor, bitOnXor));
  }

}
