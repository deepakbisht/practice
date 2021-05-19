package StackAndQueue;

import java.util.Stack;

/**
 * Created By Deepak Bisht on 28/05/20
 */
public class StackWithMiniMumOptimized {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static void push(int value) {
        s1.push(value);
        if(s2.isEmpty()) {
            s2.push(value);
        } else {
            if(s2.peek() >= value) {
                s2.push(value);
            }
        }
    }

    public static int pop() {
        if (s1.isEmpty()) {
            return -1;
        } else {
            if (s1.peek().equals(s2.peek())) {
                s1.pop();
                return s2.pop();
            } else {
                return s1.pop();
            }
        }
    }

    public static int getMin(){
       if(s2.isEmpty()) {
           return -1;
       } else {
           return s2.peek();
       }
    }

    public static void main(String[] args) {
        push(2);
        push(3);
        push(1);
        push(1);
        push(5);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(getMin());

        System.out.println(getMin());


   //     System.out.println(getMin());
        System.out.println(s2);
    }
}
