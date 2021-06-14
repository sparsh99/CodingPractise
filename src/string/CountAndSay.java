package string;

public class CountAndSay {

  public static void main(String[] args) {
    System.out.println(new CountAndSay().countAndSay(1));
    System.out.println(new CountAndSay().countAndSay(5));
  }

  public String countAndSay(int A) {
    String prev = "1";
    for (int i=1; i<A; i++) {
      StringBuilder sb = new StringBuilder();
      int cnt = 1;
      for(int j=1; j < prev.length(); j++) {
        if(prev.charAt(j) != prev.charAt(j-1)) {
          sb.append(cnt).append(prev.charAt(j-1));
          cnt = 1;
        } else {
          cnt++;
        }
      }

      sb.append(cnt).append(prev.charAt(prev.length() - 1));
      prev = sb.toString();
    }

    return prev;
  }
}
