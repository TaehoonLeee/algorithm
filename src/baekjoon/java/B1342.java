package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1342 {
    private static String str;
    private static boolean[] visited;
    private static String ans = "";
    private static List<String> answers;
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];
        answers = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            visited[i] = true;
            dfs(ans+str.charAt(i), 0);
            visited[i] = false;
        }

        char[] alphabet = new char[26];
        for(int i = 0; i < str.length(); i++) {
            alphabet[str.toCharArray()[i] - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(alphabet[i] >= 2) {
                size /= factorial(alphabet[i]);
            }
        }

        System.out.println(size);
    }

    private static void dfs(String ans, int depth) {
        if(depth == str.length()-1) {
            size++;

            return;
        }

        for(int i = 0; i < str.length(); i++) {
            if (!visited[i] && str.charAt(i) != ans.charAt(depth)) {
                visited[i] = true;
                dfs(ans + str.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int factorial(int n) {
        if(n == 1) return 1;

        return n*factorial(n-1);
    }
}
