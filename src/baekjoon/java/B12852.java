package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12852 {
    static int n;
    static int[] dp;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        nums = new int[n+1];

        backtracking(n);
        System.out.println(dp[n]);
        while(n != 0) {
            System.out.print(n + " ");
            n = nums[n];
        }
        System.out.println();
    }

    static private void backtracking(int n) {
        dp[0] = dp[1] = 0;
        nums[0] = nums[1] = 0;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            nums[i] = i - 1;
            if(i % 3 == 0) {
                nums[i] = dp[i] < dp[i/3]+1 ? i-1 : i/3;
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
            if(i % 2 == 0) {
                if(dp[i] > dp[i/2]+1) {
                    nums[i] = i / 2;
                    dp[i] = dp[i/2]+1;
                }
            }
        }
    }
}
