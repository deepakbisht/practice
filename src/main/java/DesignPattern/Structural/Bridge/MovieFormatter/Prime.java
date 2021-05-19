package DesignPattern.Structural.Bridge.MovieFormatter;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created By Deepak Bisht on 18/05/21
 * Write a program in your favored IDE and programming language to check whether
 * a given number is prime or not. The program must be executable and should display
 *
 *  <number> is prime
 *
 * if the given number is prime and
 *
 *  <number> is not prime
 *
 * otherwise. <number> is a placeholder for the value of the number, e.g. 15.
 *
 * ## Numbers to check:
 * - 15, 37, 121, 127, 11293, 11299
 *
 * ## Hints
 * - Prime numbers are numbers that have only two factors: one and themselves
 *
 *
 * Write a bracket parser that checks for correct number of bracket pairs of type
 * * '(' and ')'
 * * '{' and '}'
 *
 * for a given input string. It should display "ok" if the given string/expression
 * has a correct bracket pair configuration, and display "failed" otherwise.
 *
 * ## Strings to test
 * 1) `(defun avg (n1 n2 n3 n4)(/ (+ n1 n2 n3 n4) 4))(write(avg 10 20 30 40))` &rarr; ok
 * 2) `({(1 + x)**2 + x} + 1)*(1 + x)` &rarr; ok
 * 3) `(a + b*(c + d} / {a - d)*3)` &rarr; failed
 * 4) `(x + q)^3 + 3*{x - q} + {(x-q)*q} + ({x-q}*x)^2` &rarr; ok
 * 5) `(x + q)^3 + 3*{x - q + ({(x-q)*q} + ({x-q}*x)^2})` &rarr; failed
 *
 * ## Hints:
 * - `({})` is matching, because the outer and inner brackets form pairs
 * - `((){}` is not matching, because the 1st `(` has no partner
 * - `()){}` is not matching, because the 2nd `)` has no partner
 * - `({)}` is also not matching, because pairs must be either entirely inside/outside other pairs
 */
public class Prime {


    static boolean areValidBrackets(String str) {
        Set<Character> openingBrackets = new HashSet<>();
        openingBrackets.add('(');
        openingBrackets.add('{');
        Set<Character> closingBrackets = new HashSet<>();
        closingBrackets.add(')');
        closingBrackets.add('}');
        Stack<Character> brackets = new Stack<>();
        for(int i = 0;i <str.length();i ++) {
            if(openingBrackets.contains(str.charAt(i))) {
                brackets.push(str.charAt(i));
            } else {
                if (closingBrackets.contains(str.charAt(i))) {
                    if (str.charAt(i) == ')') {
                        if (brackets.isEmpty() || brackets.peek() != '(') {
                            return false;
                        } else {
                            brackets.pop();
                        }
                    } else {
                        if (brackets.isEmpty() ||brackets.peek() != '{') {
                            return false;
                        } else {
                            brackets.pop();
                        }
                    }
                }
            }
        }
        if(brackets.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPrime(int num) {
        if(num<=1) {
            return false;
        }
        int half = num/2;
        for(int i = 2;i<half;i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
      //  System.out.println(isPrime(15));
        System.out.println(areValidBrackets("({)}"));
    }
}
