package math;

import java.util.ArrayList;
import java.util.List;

public class ConvertToTitle {

  public static void main(String[] args) {
    System.out.println(new ConvertToTitle().convertToTitle(943566));
  }

  public String convertToTitle(int A) {
    // 0 is not part of this number system.
    // if A%26 == 0 => we have to reduce 26 instead of 0
    List<Integer> cofactorInBase26 = new ArrayList<>();
    while (A!=0) {
      cofactorInBase26.add((A%26 == 0) ? 26 : A%26);
      A = (A%26 == 0) ? (A-26)/26 : A/26;
    }

    String ans = "";
    char baseChar = 'A'-1;
    for (int i=0; i<cofactorInBase26.size(); i++) {
      ans += String.valueOf(((char) (baseChar + cofactorInBase26.get(i))));
    }

    return new StringBuilder(ans).reverse().toString();
  }
}
