package binarySearch;

public class BinarySearchExactMatch {

  public static void main(String[] args) {
    System.out.println(new BinarySearchExactMatch().search(new int[] {-1,0,3,5,9,12}, 9));
    System.out.println(new BinarySearchExactMatch().search(new int[] {-1,0,3,5,9,12}, 10));
    System.out.println(new BinarySearchExactMatch().search(new int[] {-1,3,5,9,12}, 3));
    System.out.println(new BinarySearchExactMatch().search(new int[] {-1,3,5,9,12}, 15));
  }

  public int search(int[] nums, int target) {

    if (nums.length%2 == 0) {
      return binarySearch(nums, target, 0, nums.length-1);
    }

    int left = 0;
    int right = nums.length - 1;
    while(left<=right) {
      int mid = left + (right - left)/2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] > target) {
        right = mid-1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public int binarySearch(int[] nums, int target, int left, int right) {
    if (left > right) {
      return -1;
    }

    int mid = left + (right-left)/2;
    if (nums[mid] == target) {
      return mid;
    }

    if (nums[mid] > target) {
      return binarySearch(nums, target, left, mid-1);
    }

    return binarySearch(nums, target, mid+1, right);
  }
}
