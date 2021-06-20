package hashing;

import java.util.Arrays;

public class WindowString {

  public static void main(String[] args) {
//    System.out.println(new WindowString().minWindow("ADOBECODEBANC", "ABC"));

    System.out.println(new WindowString().minWindow(
        "AiJIP1dNv8nceAPuFfCsR92K1x1cyxMK1mGQcGhlwS8Zusew7IZhD1CgRhkgi1BK7nYZW0WGnCuRetirqPL1vpO"
            + "R6McsWDLhWte2XRGKWZf1MzUe6a65QelHzlwedw12JlerE8oIeJmtz9hZcMxHU9H00m9coKu6uuiJdhLI2PH"
            + "vwuGUG0Zq0GWPTPymIXbAVkrUAVeCRn2QiOlNbAPNO0WMzgImdfbbxh8dto7ouoafJXzjfbbxyLpPgJuWJqx"
            + "SnKbzE8y2NRs40XY1LZAfOEucDdUt5eUlNfVhXNln7iNSbYXStn6hxzPEGf0KnbGGBvd8hrLdX0wZhgnTSmc"
            + "yg7OBKhYDMQ126w1XUkwNJCxwaazuDZQbeLA3Wy6JZQxzhpLRB0n3pJyPVW0ncsBWei4xNOZIDW4MkwBLbXi"
            + "AUTuYqH3AIqdZsRKIhSoCD034Hrkqh8JexRIdISfO11pbVXX0cqiyWpEJRrdObR53F0prggiNqvHHH5d0oLJ"
            + "sw1DkuSNuVh8o0jQswyIdDZqX8zLMhJEQ1qRAWdpPkHfL7qL24ezK8XmCHYWal53SnoS2fZwZgX6Spy3yK4n"
            + "WqZRedBQFc2cYpez4AV2kgQlLiQFFD0qWaZCw",
        "PO6l8OIeyJbQaUdOWM1dYUw3e5x8pWFkURdbFjSdu3I4Z1xLr9GgFwc2GCTDdYnX6Or8c0ur7rnYaS7mE0kUrr1"
            + "f8kRt7BJep"
    ));
  }

  public String minWindow(String A, String B) {
    char[] baseStringArr = B.toCharArray();
    Arrays.sort(baseStringArr);
    B = new String(baseStringArr);

    String ans = "";
    for (int i=0; i<A.length(); i++) {
      for (int j=i+B.length(); j<A.length(); j++) {
        String aSubstr = A.substring(i, j+1);
        char[] aSubstrArr = aSubstr.toCharArray();
        Arrays.sort(aSubstrArr);
        aSubstr = new String(aSubstrArr);
        if (aSubstr.contains(B)) {
          if (ans.isEmpty() || aSubstr.length() < ans.length()) {
            ans = A.substring(i, j+1);
            break;
          }
        }
      }
    }

    return ans;
  }

}
