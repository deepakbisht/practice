package StackAndQueue;

import java.util.Stack;

/**
 * Created By Deepak Bisht on 28/05/20
 */
public class StackWithMiniMum extends Stack<StackWithMiniMum.Node> {

    public static class Node {
        public int value;
        public int minimum;
        Node( int value, int minimum) {
            this.value = value;
            this.minimum = minimum;
        }
    }

    public void push(int value) {
        Node n = new Node(value, Math.min(value, getMin()));
        super.push(n);
    }

    public int getMin(){
        if(this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().minimum;
        }
    }
}
