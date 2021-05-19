package StackAndQueue;

import java.util.Stack;

/**
 * Created By Deepak Bisht on 27/05/20
 */
public class NextGreaterElement {

    public static void getNextGreaterElement(int [] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.println("-1");
        for(int i=1;i<arr.length;i++) {
            while (stack.peek() < arr[i]) {
                System.out.println(stack.pop() + "->" + arr[i]);
                if(stack.empty()){
                    break;
                }
            }
            stack.push(arr[i]);
        }
        while(!stack.empty()){
            System.out.println(stack.pop()+"->"+"-1");
        }
    }

    public static void main(String[] args) {
        getNextGreaterElement(new int[]{11, 13, 21, 3});
    }
}
