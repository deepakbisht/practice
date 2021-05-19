package String;

/**
 * Created By Deepak Bisht on 18/05/20
 */
public class LongestCommonPrefix {

    public static String commonPrefixutil(String str1, String str2) {
        String result = "";
        int smallStringSize = str1.length() < str2.length() ? str1.length() : str2.length();
        for (int i = 0; i < smallStringSize; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            result += str1.charAt(i);
        }
        return result;
    }

    public static String commonPrefix(String []arr, int n){

        String prefix = arr[0];
        for(int i=1;i<arr.length;i++) {
            prefix = commonPrefixutil(prefix, arr[i]);
        }
        return prefix;
    }



    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;

        String ans = commonPrefix(arr, n);

        if (ans.length() > 0) {
            System.out.printf("The longest common prefix is - %s",
                    ans);
        } else {
            System.out.printf("There is no common prefix");
        }
    }
}
