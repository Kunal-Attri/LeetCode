package leetcode;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
        Map<Character, Integer> alphabet = alphabetMap();
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (alphabet.get(s.charAt(i)) < alphabet.get(s.charAt(i+1))) {
                result -= alphabet.get(s.charAt(i));
            } else {
                result += alphabet.get(s.charAt(i));
            }
        }
        result += alphabet.get(s.charAt(s.length() - 1));
        return result;
    }
    private Map<Character, Integer> alphabetMap() {
        return Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C',100, 'D',500, 'M',1000);
    }
}
