package TEST;

import java.util.Arrays;

/**
 * Created By Deepak Bisht on 14/08/20
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        int arr[] = { 10,4,6,8 };
        int n = arr.length;
        System.out.print(maxPrimeSubarray(arr, arr.length));

        /*Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        while(n>0) {
            Integer size = s.nextInt();
            int [] arr = new int[size];
            int i =0;
            while(size>0){
                arr[i] = s.nextInt();
                i++;
                size--;
            }
 //           System.out.println(maxPrimeSubarray(arr, arr.length ));
            System.out.println(subArrayPrime(arr));
            n--;
        }*/

        // Write your code here

    }

    static void createPrimeArray(boolean prime[], int size) {
        prime[0] = false;
        prime[1] = false;
        for(int p =2; p*p <= size; p++) {
            if(prime[p]) {
                for(int i = p*2; p <= size;i += p) {
                    prime[i] = false;
                }
            }
        }
    }

    static int subArrayPrime(int arr[]) {
        int max = Arrays.stream(arr).max().getAsInt();
        boolean prime[] = new boolean[max + 1];
        Arrays.fill(prime, true);
        createPrimeArray(prime, max);
        int curr_max = 0, max_so_far = 0;
        for(int i=0;i<arr.length;i++){
            if(prime[arr[i]] == false) {
                curr_max = 0;
            }
            else {
                curr_max++;
                max_so_far = Math.max(curr_max, max_so_far);
            }
        }
        return max_so_far;
    }


    static void SieveOfEratosthenes(boolean prime[],
                                    int p_size) {
        // false here indicates
        // that it is not prime
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= p_size; p++) {

            // If prime[p] is not changed,
            // then it is a prime
            if (prime[p]) {

                // Update all multiples of p,
                // set them to non-prime
                for (int i = p * 2; i <= p_size; i += p)
                    prime[i] = false;
            }
        }
    }

    // Function that finds
// maximum contiguous subarray of prime numbers
    static int maxPrimeSubarray(int arr[], int n)
    {
        int max_ele = Arrays.stream(arr).max().getAsInt();
        boolean prime[] = new boolean[max_ele + 1];
        Arrays.fill(prime, true);

        SieveOfEratosthenes(prime, max_ele);

        int current_max = 0, max_so_far = 0;

        for (int i = 0; i < n; i++)
        {
            // check if element is non-prime
            if (prime[arr[i]] == false)
                current_max = 0;

                // If element is prime, than update
                // current_max and max_so_far accordingly.
            else
            {
                current_max++;
                max_so_far = Math.max(current_max, max_so_far);
            }
        }
        return max_so_far == 0? -1: max_so_far;
    }
}

