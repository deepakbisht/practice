import java.util.Objects;

/**
 * Created By Deepak Bisht on 18/04/21
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(countWaystoDivide(8, 4));
    }

    static int countWaystoDivide(int n, int k) {
        return calculate(0, 1, n, k);
    }

    static int calculate(int pos, int prev,
                         int left, int k) {

        // Base Case
        if (pos == k) {
            if (left == 0)
                return 1;
            else
                return 0;
        }

        // If N is divides completely
        // into less than k groups
        if (left == 0)
            return 0;

        int answer = 0;

        // Put all possible values
        // greater equal to prev
        for (int i = prev; i <= left; i++) {
            answer += calculate(pos + 1, i,
                    left - i, k);
        }
        return answer;
    }

    static int countP(int n, int k) {
        // Table to store results of subproblems
        int[][] dp = new int[n + 1][k + 1];

        // Base cases
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= k; i++)
            dp[0][k] = 0;

        // Fill rest of the entries in dp[][]
        // in bottom up manner
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++)
                if (j == 1 || i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];

        return dp[n][k];

    }
}

class Person {
    public String firstNaame;
    public String lastNaame;

    public Person(String firstNaame, String lastNaame) {
        this.firstNaame = firstNaame;
        this.lastNaame = lastNaame;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstNaame, person.firstNaame) && Objects.equals(lastNaame, person.lastNaame);
    }

}

class Male extends Person {

    public Male(String firstNaame, String lastNaame) {
        super(firstNaame, lastNaame);
    }
}

class TestDaaoen extends Thread {
    public void run() {
        System.out.println("Runnhiubn  tread is damoen");
    }
}

