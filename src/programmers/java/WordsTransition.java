package programmers.java;

import java.util.*;

class WordsTransition {
    private static int answer, count;
    private static boolean[] visited;
    private static List<Integer> answers;
    private static List<String> path;

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        count = 0;
        answers = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[words.length];

        for(int i = 0; i < words.length; i++) {
            int cnt = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) cnt++;
            }
            if(cnt == 1) {
                visited[i] = true;
                dfs(words[i], target, words, 0);
                visited[i] = false;
            }
        }

        if(answers.size() > 0) {
            Collections.sort(answers);
            answer = answers.get(0);
        }
        else answer = 0;

        return answer;
    }

    private static void dfs(String begin, String target, String[] words, int depth) {
        path.add(begin);
        if(begin.equals(target)) {
            answers.add(path.size());

            return;
        }
        else if(depth == words.length) return;

        for(int i = 0; i < words.length; i++) {
            int cnt = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) cnt++;
            }
            if(cnt == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, i);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}