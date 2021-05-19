package StackAndQueue;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Deepak Bisht on 31/05/20
 */
public class FirstNonRepeatingElement {

    static Queue<Character> characterQueue = new LinkedList<Character>();
    static  Character findFirstNotRepeatingElement(String stream) {
        if(stream == null) {
            return null;
        }
        if(stream.length() == 1) {
            System.out.println(stream + ":" + stream.charAt(0));
        }
        int [] charCounter = new int[26];
        Arrays.fill(charCounter,0);

        for (int i = 0; i < stream.length(); i++) {
            characterQueue.add(stream.charAt(i));
            charCounter[stream.charAt(i) - 'a']++;
            if (charCounter[stream.charAt(i)-'a'] > 1) {
                while (!characterQueue.isEmpty()) {
                    if (charCounter[characterQueue.peek()-'a'] > 1) {
                        characterQueue.remove();
                    } else {
                        System.out.println(stream.charAt(i) + ":" + characterQueue.peek());
                        break;
                    }
                }
            } else {
                System.out.println(stream.charAt(i) + ":" +characterQueue.peek());
            }
            if (characterQueue.isEmpty()) {
                System.out.println(stream.charAt(i) + ":" + "-1");
            }
        }
        return characterQueue.peek();
    }

    public static void main(String[] args) {
        findFirstNotRepeatingElement("aabcdbefgaki");
    }
}
