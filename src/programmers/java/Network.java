package programmers.java;

class Network {
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int from, int n, int[][] computers) {
        visited[from] = true;

        for(int i = 0; i < n; i++) {
            if(computers[from][i] == 1 && !visited[i]) {
                dfs(i, n, computers);
            }
        }
    }
}