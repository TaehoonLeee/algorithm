package baekjoon.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1926 {
    static String[][] maps;
    static Boolean[][] visited;
    static int number = 0;
    static int row, col;
    static int max = 0;
    static List<Integer> maxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        maps = new String[row][col];
        visited = new Boolean[row][col];

        for(int i = 0; i < row; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < col; j++) {
                maps[i][j] = tmp[j];
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(maps[i][j].equals("1") && !visited[i][j]) {
                    max = 0;
                    dfs(i, j);
                    number++;
                    maxes.add(max);
                }
            }
        }

        Collections.sort(maxes, Collections.reverseOrder());

        bw.write(number+"\n");
        if(!maxes.isEmpty()) bw.write(maxes.get(0)+"\n");
        else bw.write(String.valueOf(0)+"\n");

        bw.flush();
        bw.close();

    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        max++;

        if(r+1 < row && maps[r+1][c].equals("1") && !visited[r+1][c]) {
            dfs(r+1, c);
        }
        if(c+1 < col && maps[r][c+1].equals("1") && !visited[r][c+1]) {
            dfs(r, c+1);
        }
        if(r-1 >= 0 && maps[r-1][c].equals("1") && !visited[r-1][c]) {
            dfs(r-1, c);
        }
        if(c-1 >= 0 && maps[r][c-1].equals("1") && !visited[r][c-1]) {
            dfs(r, c-1);
        }
    }
}
