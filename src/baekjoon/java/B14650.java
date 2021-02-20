package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14650 {
    private static String[] nums = {"0", "1", "2"};
    private static int n;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        func("1");
        func("2");

        System.out.println(answer);
    }

    private static void func(String str) {
        if(str.length() == n) {
            if(Integer.parseInt(str) % 3 == 0) answer++;
            return;
        }

        func(str+nums[0]);
        func(str+nums[1]);
        func(str+nums[2]);
    }
}