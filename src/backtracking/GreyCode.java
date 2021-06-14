package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreyCode {

  public static void main(String[] args) {
    new GreyCode().grayCode(3).forEach(n -> System.out.println(Integer.toBinaryString(n)));
  }

  public ArrayList<Integer> grayCode(int a) {
    if (a==1) {
      List<Integer> b = Arrays.asList(0, 1);
      return new ArrayList<>(b);
    }

    ArrayList<Integer> c1 = grayCode(a-1);
    ArrayList<Integer> c = new ArrayList<>(c1);
    for (int i=c1.size()-1; i >= 0 ; i--) {
      c.add((1 << a-1) + c1.get(i));
    }

    return c;
  }
}
