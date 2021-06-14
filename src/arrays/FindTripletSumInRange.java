package arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class FindTripletSumInRange {

  public int solve(ArrayList<String> A) {
    A.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Double.valueOf(o1).compareTo(Double.valueOf(o2));
      }
    });

    for (int i=0; i<A.size(); i++) {
      for (int j=i+1; j<A.size(); j++) {
        Double pairSum = Double.valueOf(A.get(i)) + Double.valueOf(A.get(j));
        // 1-pairSum < x < 2-pairSum
        int rangeS = binarySearch(A, j+1, A.size() - 1, 1-pairSum);
        int rangeE = binarySearch(A, j+1, A.size() - 1, 2-pairSum);
        if (rangeS < rangeE) return 1;
      }
    }

    return 0;
  }

  private int binarySearch(ArrayList<String> arr, int start, int end, Double searchTerm) {
    if (start == end) {
      return start;
    }

    int mid = (start + end)/2;
    if (Double.valueOf(arr.get(mid)).equals(searchTerm)) {
      return mid;
    } else if (Double.valueOf(arr.get(mid)).compareTo(searchTerm) > 0) {
      return binarySearch(arr, start, mid-1, searchTerm);
    } else {
      return binarySearch(arr, mid+1, end, searchTerm);
    }
  }

}
