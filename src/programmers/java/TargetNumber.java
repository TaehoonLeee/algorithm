package programmers.java;

class TargetNumber {
    private static int answer, val;

    public int solution(int[] numbers, int target) {
        answer = 0;
        val = target;
        dfs(numbers, 0);

        return answer;
    }

    private static void dfs(int[] numbers, int depth) {
        if(depth == numbers.length) {
            int sum = 0;
            for(int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if(sum == val) answer++;

            return;
        }
        numbers[depth] -= 2*numbers[depth];
        dfs(numbers, depth+1);

        numbers[depth] -= 2*numbers[depth];
        dfs(numbers, depth+1);
    }
}