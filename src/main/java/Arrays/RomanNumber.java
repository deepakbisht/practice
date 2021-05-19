package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Deepak Bisht on 16/05/20
 */
public class RomanNumber {

    public static Map<Character, Integer> defaultMap = new HashMap<>();

    static {
        defaultMap.put('I', 1);
        defaultMap.put('V', 5);
        defaultMap.put('X', 10);
    }

    public static int convertRomanToInt(String roman) {
        int number = 0;
        boolean flag = true;
        for (int i = roman.length() - 1; i >= 0; i--) {
            if (roman.charAt(i) == 'I') {
                if (flag) {
                    number += defaultMap.get(roman.charAt(i));
                } else {
                    number -= defaultMap.get(roman.charAt(i));
                }
            } else {
                flag = false;
                number += defaultMap.get(roman.charAt(i));
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(convertRomanToInt("XXXXVIII"));
    }
}
