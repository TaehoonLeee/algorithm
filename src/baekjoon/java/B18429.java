package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18429 {
    private static int n, k, answer;
    private static int[] kits;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = new String[2];
        tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);
        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        kits = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        dfs(500, 0);
        System.out.println(answer);
    }

    private static void dfs(int weight, int depth) {
        if(weight < 500) return;

        if(depth == n) {
            answer++;

            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(weight-k+kits[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
