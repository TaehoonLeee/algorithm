package programmers.java;

import java.util.*;

class PrimeNumber {
    private static char[] nums;
    private static boolean[] visited;
    private static List<Integer> cases;
    private static int n;
    private static int answer;

    public int solution(String numbers) {
        answer = 0;

        cases = new ArrayList<>();
        n = numbers.length();
        nums = new char[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            dfs(0, numbers, i+1);
        }

        return answer;
    }

    private static void dfs(int pos, String numbers, int size) {
        if(pos == size) {
            if(isPrime(nums, size)) {
                answer++;
                return;
            }
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                nums[pos] = numbers.charAt(i);
                dfs(pos+1, numbers, size);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime(char[] nums, int size) {
        if(nums[0] == '0') return false;

        String number = "";
        for(int i = 0; i < size; i++) {
            number += nums[i];
        }

        int num = Integer.parseInt(number);

        boolean duplicated = false;
        for(int i = 0; i < cases.size(); i++) {
            if(num == cases.get(i)) duplicated = true;
        }

        if(num == 1 || duplicated) return false;
        if(!duplicated) {
            for(int i = 2; i * i <= num; i++) {
                if(num % i == 0) {
                    return false;
                }
            }
        }

        if(!duplicated) cases.add(num);

        return true;
    }
}