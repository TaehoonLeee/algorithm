package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class B5212 {
    private static char[][] map;
    private static char[][] postMap;
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r+2][c+2];
        postMap = new char[r+2][c+2];

        for(int i = 1; i <= r; i++) {
            map[i][0] = '.';
            map[i][c+1] = '.';
        }
        for(int i = 1; i <= c; i++) {
            map[0][i] = '.';
            map[r+1][i] = '.';
        }

        for(int i = 1; i <= r; i++) {
            String row = br.readLine();
            for(int j = 1; j <=c; j++) {
                map[i][j] = row.charAt(j-1);
                postMap[i][j] = row.charAt(j-1);
            }
        }

        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <=c; j++) {
                if(map[i][j] == 'X' && isWillBeSea(i, j)) postMap[i][j] = '.';
            }
        }

        toPrintCoordinate(bw);
        bw.close();
    }

    private static boolean isWillBeSea(int i, int j) {
        int cnt = 0;
        if(map[i-1][j] == '.') cnt++;
        if(map[i][j-1] == '.') cnt++;
        if(map[i+1][j] == '.') cnt++;
        if(map[i][j+1] == '.') cnt++;

        return cnt >= 3;
    }

    private static void toPrintCoordinate(BufferedWriter bw) throws IOException {
        int startCol = Integer.MAX_VALUE; int startRow = Integer.MAX_VALUE;
        int endCol = 0; int endRow = 0;
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(postMap[i][j] == 'X') {
                    startRow = Math.min(startRow, i);
                    startCol = Math.min(startCol, j);
                    endRow = Math.max(endRow, i);
                    endCol = Math.max(endCol, j);
                }
            }
        }

        for(int i = startRow; i <= endRow; i++) {
            for(int j = startCol; j <= endCol; j++) {
                bw.write(postMap[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
