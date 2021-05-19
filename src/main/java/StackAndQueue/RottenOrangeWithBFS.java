package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Deepak Bisht on 01/06/20
 */
public class RottenOrangeWithBFS {

    static class Element {
        int x =0;
        int y=0;
        Element(int x, int y){
            this.x =x;
            this.y=y;
        }
    }

    static boolean isValid(int i, int j, int row, int col) {
        return (i >= 0 && j >= 0 && i < row && j < col);
    }

    static boolean isDelim(Element temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    static int allRottenTime(int[][] arr) {
        int count = 0;
        Queue<Element> elementQueue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    elementQueue.add(new Element(i, j));
                }
            }
        }
        // indicator
        elementQueue.add(new Element(-1, -1));
        while (!elementQueue.isEmpty()) {
            Element element = elementQueue.peek();
            if (!isDelim(element)) {
                //up
                if (isValid(element.x - 1, element.y, arr.length, arr[0].length)) {
                    if (arr[element.x - 1][element.y] == 1) {
                        arr[element.x - 1][element.y] = 2;
                        elementQueue.add(new Element(element.x - 1, element.y));
                    }
                }
                //down
                if (isValid(element.x + 1, element.y, arr.length, arr[0].length)) {
                    if (arr[element.x + 1][element.y] == 1) {
                        arr[element.x + 1][element.y] = 2;
                        elementQueue.add(new Element(element.x + 1, element.y));
                    }
                }
                //left
                if (isValid(element.x, element.y - 1, arr.length, arr[0].length)) {
                    if (arr[element.x][element.y - 1] == 1) {
                        arr[element.x][element.y - 1] = 2;
                        elementQueue.add(new Element(element.x, element.y - 1));
                    }
                }
                //right
                if (isValid(element.x, element.y + 1, arr.length, arr[0].length)) {
                    if (arr[element.x][element.y + 1] == 1) {
                        arr[element.x][element.y + 1] = 2;
                        elementQueue.add(new Element(element.x, element.y + 1));
                    }
                }
                elementQueue.remove();
            } else {
                elementQueue.remove();
                if (!elementQueue.isEmpty()) {
                    count++;
                    //add delimeter again
                    elementQueue.add(new Element(-1, -1));
                }
            }
        }

        if(!checkIfAllRotten(arr)){
            return -1;
        }

        return count;
    }

    public static boolean checkIfAllRotten(int [][]arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                   return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = {{2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println(allRottenTime(arr));
    }

}
