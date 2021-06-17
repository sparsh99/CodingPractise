package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {

  private static Map<Character, List<Character>> noToCharacterMap = new HashMap<Character, List<Character>>() {{
    put('0', Arrays.asList('0'));
    put('1', Arrays.asList('1'));
    put('2', Arrays.asList('a', 'b', 'c'));
    put('3', Arrays.asList('d', 'e', 'f'));
    put('4', Arrays.asList('g', 'h', 'i'));
    put('5', Arrays.asList('j', 'k', 'l'));
    put('6', Arrays.asList('m', 'n', 'o'));
    put('7', Arrays.asList('p', 'q', 'r', 's'));
    put('8', Arrays.asList('t', 'u', 'v'));
    put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }};

  public static void main(String[] args) {
    System.out.println(
        new LetterPhone().letterCombinations("012")
    );
  }

  public ArrayList<String> letterCombinations(String A) {
    return new ArrayList<>(letterCombinations(A, 0));
  }

  public List<String> letterCombinations(String A, int index) {
    if (index == A.length()) {
      return Collections.singletonList("");
    }

    List<String> subAnswers = letterCombinations(A, index+1);
    List<String> answers = new ArrayList<>();
    for (Character c : noToCharacterMap.get(A.charAt(index))) {
      for (String subAns : subAnswers) {
        answers.add(c + subAns);
      }
    }

    return answers;
  }
}
