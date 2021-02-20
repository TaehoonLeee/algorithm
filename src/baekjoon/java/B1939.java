package baekjoon.java;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1939 {
    private static ArrayList<Vertex>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int max = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Vertex(end, weight));
            graph[end].add(new Vertex(start, weight));
            max = Math.max(max, weight);
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = max;
        int answer = 0;
        while(start <= end) {
            boolean[] visited = new boolean[n+1];
            int mid = (start + end) / 2;
            if(isPossible(startPoint, endPoint, mid, visited)) {
                start = mid+1;
                answer = Math.max(answer, mid);
            }
            else end = mid - 1;
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    private static boolean isPossible(int start, int end, int limit, boolean[] visited) {
        if(visited[start]) {
            return false;
        }
        visited[start] = true;
        if(start == end) {
            return true;
        }

        for(Vertex v : graph[start]) {
            if(v.weight >= limit) {
                if(isPossible(v.end, end, limit, visited)) return true;
            }
        }

        return false;
    }

    static class Vertex {
        int end;
        int weight;

        Vertex(int _end, int _weight) {
            this.end = _end;
            this.weight = _weight;
        }
    }
}
