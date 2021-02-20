package baekjoon.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1644 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        boolean prime[];
        prime = new boolean[N+1];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i*i <= N; i++) {
            if(!prime[i]) for(int j = i*i; j<= N; j+=i) prime[j] = true;
        }

        List<Integer> prime_numbers = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(!prime[i]) prime_numbers.add(i);
        }

        int start = 0, end = 0, sum = 0, cnt = 0;
        while(true) {
            if (N <= sum) sum -= prime_numbers.get(start++);
            else if (end == prime_numbers.size()) break;
            else sum += prime_numbers.get(end++);

            if(N == sum) cnt++;
        }

        System.out.println(cnt);
    }
}
