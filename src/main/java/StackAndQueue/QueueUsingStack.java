package StackAndQueue;

import java.util.Stack;

/**
 * Created By Deepak Bisht on 27/05/20
 */
public class QueueUsingStack {

    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    static void enQueue(int x)
    {
        while (!s1.isEmpty())
        {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
    }

    static int deQueue()
    {
        if (s1.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }
}
