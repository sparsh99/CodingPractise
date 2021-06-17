package hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

  public static void main(String[] args) {
//    System.out.println(
//        new ColorfulNumber().colorful(5)
//    );
//
//    System.out.println(
//        new ColorfulNumber().colorful(23)
//    );
//
//    System.out.println(
//        new ColorfulNumber().colorful(3245)
//    );

    System.out.println(
        new ColorfulNumber().colorful(123)
    );
  }

  public int colorful(int A) {
    String B = String.valueOf(A);
    Set<Integer> products = new HashSet<>();
    for (int i=0; i<B.length(); i++) {
      int p = 1;
      for (int j=i; j<B.length(); j++) {
        p *= Integer.valueOf("" + B.charAt(j));
        if (products.contains(p)) {
          return 0;
        }

        products.add(p);
      }
    }

    return 1;
  }
}
