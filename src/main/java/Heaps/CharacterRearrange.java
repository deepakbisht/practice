package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created By Deepak Bisht on 02/07/20
 */
public class CharacterRearrange {

    static class KeyComparator implements Comparator<Key> {

        @Override
        public int compare(Key o1, Key o2) {
            if (o1.getFrequency() < o2.getFrequency()) {
                return 1;
            } else if (o1.getFrequency() > o2.getFrequency()) {
                return -1;
            }
            return 0;
        }
    }

    static class Key {
        int frequency;
        char ch;

        public int getFrequency() {
            return frequency;
        }

        public char getCh() {
            return ch;
        }

        public Key() {
        }

        public Key(int frequency, char ch) {
            this.frequency = frequency;
            this.ch = ch;
        }
    }

    static void rearrange(String str) {
        int[] charCount = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for(int i =0;i<26;i++) {
            if(charCount[i]>0) {
                char c = (char) (i + 97);
                pq.add(new Key(charCount[i], c));
            }
        }

        Key prev = new Key(-1, '#');
        String  result = "";

        while(pq.size()!=0) {
            Key k = pq.poll();
            result += k.ch;
            if(prev.frequency>0){
                pq.add(prev);
            }
            (k.frequency)--;
            prev = k;
        }
        if(result.length()!=str.length()) {
            System.out.println("NOT VALID");
        } else {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        String str = "aaabbccd";
        rearrange(str);
    }
}
