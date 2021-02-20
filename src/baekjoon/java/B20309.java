package baekjoon.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B20309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            nums.add(scanner.nextInt());
        }

        String answer = "YES";
        for(int i = 0; i < N; i++) {
            if( (nums.get(i) % 2) == (i % 2) ) answer = "NO";
        }

        System.out.println(answer);
    }
}
