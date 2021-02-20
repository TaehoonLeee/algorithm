package baekjoon.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1446 {
    private static List<Edge> path = new ArrayList<>();
    private static int[] dp;
    private static int distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        dp = new int[distance+1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (to > distance || to - from <= weight) continue;
            path.add(new Edge(from, to, weight));
        }

        path.sort((o1, o2) -> {
            int compare = Integer.compare(o1.from, o2.from);
            if (o1.from == o2.from)
                compare = Integer.compare(o1.to, o2.to);

            return compare;
        });

        dijkstra();
        bw.write(dp[distance]+"\n");
        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int index = 0, move = 0;

        while(move < distance) {
            if(index < path.size()) {
                Edge edge = path.get(index);
                if (move == edge.from) {
                    dp[edge.to] = Math.min(dp[move] + edge.weight, dp[edge.to]);
                    index++;
                }
                else {
                    dp[move+1] = Math.min(dp[move+1], dp[move]+1);
                    move++;
                }
            }
            else {
                dp[move+1] = Math.min(dp[move+1], dp[move]+1);
                move++;
            }
        }
    }

    static class Edge {
        int from, to, weight;

        Edge(int _from, int _to, int _weight) {
            this.from = _from;
            this.to = _to;
            this.weight = _weight;
        }
    }
}
