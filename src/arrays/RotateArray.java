package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

  public static void main(String[] args) {
    List<List<Integer>> a = Arrays.asList(
        Arrays.asList(1, 2),
        Arrays.asList(3, 4)
    );

    new RotateArray().rotate(a);
  }

  public void rotate(List<List<Integer>> a) {

    // Transpose
    for(int i=0; i<a.size(); i++) {
      for(int j=0; j<i; j++) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(j).get(i));
        a.get(j).set(i, temp);
      }
    }

    print(a);

    // reflect vertically
    for (int j=0; j<a.size()/2;j++) {
      for (int i=0; i<a.size(); i++) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(i).get(a.size()-j-1));
        a.get(i).set(a.size()-j-1, temp);
      }
    }

    print(a);
  }

  public void print(List<List<Integer>> a) {
    for (int i=0; i<a.size(); i++) {
      for (int j=0; j<a.size(); j++) {
        System.out.print(a.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}
