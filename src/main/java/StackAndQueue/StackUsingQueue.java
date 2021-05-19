package StackAndQueue;

import java.util.LinkedList;

/**
 * Created By Deepak Bisht on 27/05/20
 */
public class StackUsingQueue {

    static LinkedList<Integer>  q1 = new LinkedList();
    static LinkedList<Integer>  q2 = new LinkedList();

    public static void push(int x) {
        if(q1.isEmpty()){
            if(q2.isEmpty()){
                q1.add(x);
            } else{
                q2.add(x);
            }

        } else {
            q1.add(x);
        }
    }

    public static int pop() {
        if(q1.isEmpty()){
            if(q2.isEmpty()) {
                return -1;
            } else{
                while(q2.size()!=1) {
                    q1.add(q2.remove());
                }
                int x  = q2.get(0);
                q2.remove();
                return x;
            }
        } else {
            while(q1.size()!=1) {
                q2.add(q1.remove());
            }
            int x  = q1.get(0);
            q1.remove();
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println(pop());
        push(10);
        push(40);
        push(50);

        System.out.println(pop());
        System.out.println(pop());System.out.println(pop());

    }
}
