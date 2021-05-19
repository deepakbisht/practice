package String;

/**
 * Created By Deepak Bisht on 15/05/20
 */
public class RemoveAdjacentDuplicates {


    public static String removeAllAdjacentKind(String str) {
        String removedString="";
        int i = 0;
        while (i < str.length() - 1) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                i = skipTillIndex(str.charAt(i), str, i);
            }
            else {
                removedString += str.charAt(i);
                i++;
            }
            if (i == (str.length() - 1)) {
                if (str.charAt(i) != str.charAt(i - 1)) {
                    removedString += str.charAt(i);
                }
            }
        }

       if(str.equals(removedString)) {
           return removedString;
       }
       return removeAllAdjacentKind(removedString);
    }

    public static int skipTillIndex(char ch,String str, int i) {
        while(i < str.length() && str.charAt(i) == ch) {
            i++;
        }
   //     System.out.println("Duplicate till: "+ i+" char:" + str.charAt(i));
        return i;
    }

    static String removeUtil(String str, char last_removed)
    {
        // If length of string is 1 or 0
        if (str.length() == 0 || str.length() == 1)
            return str;

        // Remove leftmost same characters and recur for remaining
        // string
        if (str.charAt(0) == str.charAt(1))
        {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1, str.length());
            str = str.substring(1, str.length());
            System.out.println(str);
            return removeUtil(str, last_removed);
        }

        // At this point, the first character is definitely different
        // from its adjacent. Ignore first character and recursively
        // remove characters from remaining string
        String rem_str = removeUtil(str.substring(1,str.length()), last_removed);

        // Check if the first character of the rem_string matches with
        // the first character of the original string
        if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0))
        {
            last_removed = str.charAt(0);
            System.out.println(rem_str.substring(1,rem_str.length()));
            return rem_str.substring(1,rem_str.length()); // Remove first character
        }


        // If remaining string becomes empty and last removed character
        // is same as first character of original string. This is needed
        // for a string like "acbbcddc"
        if (rem_str.length() == 0 && last_removed == str.charAt(0)) {
            System.out.println(rem_str);
            return rem_str;
        }
        // If the two first characters of str and rem_str don't match,
        // append first character of str before the first character of
        // rem_str
        System.out.println(str.charAt(0) + rem_str);
        return (str.charAt(0) + rem_str);
    }

    static String remove(String str)
    {
        char last_removed = '\0';
        return removeUtil(str, last_removed);
    }
    public static void main(String[] args) {
        String str = "azxxxzy";
       // System.out.println(removeAllAdjacentKind(str));

        String str8 = "acbbcddc";
        System.out.println(remove(str8));
    }

}
