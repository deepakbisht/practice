package StackAndQueue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created By Deepak Bisht on 27/05/20
 */
public class Parenthesis {

    public static String isBalancedParenthesis(String strParenthesis) {
        Set<Character> openingParenthesis = new HashSet<>(3);
        openingParenthesis.add('{');
        openingParenthesis.add('[');
        openingParenthesis.add('(');
        Set<Character> closingParenthesis = new HashSet<>(3);
        closingParenthesis.add('}');
        closingParenthesis.add(']');
        closingParenthesis.add(')');
        Stack<Character> parenthesis = new Stack<>();
        if (strParenthesis == null) {
            return "balanced";
        }
        for (int i = 0; i < strParenthesis.length(); i++) {
            if (openingParenthesis.contains(strParenthesis.charAt(i))) {
                parenthesis.push(strParenthesis.charAt(i));
            }
            if (closingParenthesis.contains(strParenthesis.charAt(i))) {
                if (!(isParenthesisEqual(strParenthesis.charAt(i), parenthesis.pop()))) {
                    return "unbalanced";
                }
            }
        }
        if (parenthesis.isEmpty()) {
            return "balanced";
        }
        return "unbalanced";
    }

    static boolean isParenthesisEqual(char a, char b) {
        switch (a) {
            case '}':
                return b == '{';
            case ']':
                return b == '[';
            case ')':
                return b == '(';
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isBalancedParenthesis("{(}"));
    }
}
