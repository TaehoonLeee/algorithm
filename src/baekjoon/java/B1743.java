package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class B1743 {
    private static int n, m, k, cnt = 0, ans = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt++;

        for(int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (x >= 0 && y >= 0 && x < n+1 && y < m+1) {
                if (!visited[x][y] && map[x][y] == 1) {
                    dfs(x, y);
                }
            }
        }
    }
}
