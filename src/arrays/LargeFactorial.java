package arrays;

import java.math.BigInteger;

public class LargeFactorial {

  public static void main(String[] args) {
    System.out.println(new LargeFactorial().solveString(100));
  }

  public String solveBigInt(int A) {
    BigInteger b = new BigInteger("1");
    for(int i=1; i<=A; i++) {
      b = b.multiply(new BigInteger(String.valueOf(i)));
    }

    return b.toString();
  }

  public String solveString(int A) {
    String s = "1";
    for (int i=1; i<=A; i++) {

    }

    return s;
  }

}
