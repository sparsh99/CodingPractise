package string;

public class ConvertToPalindrome {

  public static void main(String[] args) {
    System.out.println(new ConvertToPalindrome().solve("qifjhwvhvohmnnibd"));
    System.out.println(new ConvertToPalindrome().solve("aaabbbaaca"));
    System.out.println(new ConvertToPalindrome().solve("iph"));
  }

  public int solve(String A) {
    int i=0;
    while (i<A.length()/2 && A.charAt(i) == A.charAt(A.length()-i-1)) {
      i++;
    }

    boolean isPalindromePossible = true;

    // skip left
    for (int j=i+1; j<=A.length()/2; j++) {
      if (A.charAt(j) != A.charAt(A.length()-j)) {
        isPalindromePossible = false;
        break;
      }
    }

    if (isPalindromePossible) {
      return 1;
    }

    // skip right
    isPalindromePossible = true;
    for (int j=i; j<=(A.length()-2)/2; j++) {
      if (A.charAt(j) != A.charAt(A.length()-2-j)) {
        isPalindromePossible = false;
        break;
      }
    }

    if (isPalindromePossible) {
      return 1;
    }

    return 0;
  }
  /*
  // we can do it in single loop instead of three. we just need
  // to choose correct increment if mismatch is found
      public int solve(String A) {
        int l = 0;
        int r = A.length()-1;
        boolean removed = false;
        while (l < r){
            if (A.charAt(l) == A.charAt(r)){
                l++;
                r--;
            }
            else{
                if (removed){
                    return 0;
                }
                removed = true;
                if (A.charAt(l+1) == A.charAt(r)){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return 1;
    }
   */
}
