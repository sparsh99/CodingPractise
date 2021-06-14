package binarySearch;

public class BinarySearchClosestMatch {

  public static void main(String[] args) {
    System.out.println(new BinarySearchClosestMatch().search(new int[] {-1,0,3,5,9,12}, 9));
    System.out.println(new BinarySearchClosestMatch().search(new int[] {-1,0,3,5,9,12}, 10));
    System.out.println(new BinarySearchClosestMatch().search(new int[] {-1,3,5,9,12}, 3));
    System.out.println(new BinarySearchClosestMatch().search(new int[] {-1,3,5,9,12}, 15));
    System.out.println(new BinarySearchClosestMatch().search(new int[] {-1,3,5,9,12}, -10));
  }

  public int search(int[] arr, int target) {
    // closest match is defined by absolute with any number

    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (arr[mid] == target) {
        return mid;
      }

      if (arr[mid] > target) {
        if (mid == 0) {
          return mid;
        } else if (arr[mid - 1] < target) {
          if (Math.abs(target - arr[mid - 1]) < Math.abs(target - arr[mid])) {
            return mid-1;
          } else {
            return mid;
          }
        } else {
          right = mid - 1;
        }
      } else {
        if (mid == arr.length - 1) {
          return arr.length - 1;
        } else {
          left = mid + 1;
        }
      }
    }

    return -1;
  }

}
