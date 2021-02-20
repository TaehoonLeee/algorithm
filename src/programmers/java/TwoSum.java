package programmers.java;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class TwoSum {
    private static Set<Integer> numberList = new HashSet<>();
    private static boolean[] visited;

    public int[] solution(int[] numbers) {
        visited = new boolean[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            visited[i] = true;
            dfs(numbers, 1, numbers[i]);
            visited[i] = false;
        }

        int[] answer = new int[numberList.size()];
        int index = 0;
        for(Integer value : numberList) {
            answer[index++] = value.intValue();
        }
        Arrays.sort(answer);

        return answer;
    }

    private static void dfs(int[] numbers, int depth, int number) {
        if(depth == 2) {
            numberList.add(number);
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, depth+1, number+numbers[i]);
                visited[i] = false;
            }
        }
    }
}
