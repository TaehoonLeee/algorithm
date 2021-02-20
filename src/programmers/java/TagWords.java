package programmers.java;

import java.util.ArrayList;
import java.util.List;

class TagWords {
    private static List<String> wordList = new ArrayList<>();

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        wordList.add(words[0]);
        int person = 0;
        int order = 0;
        for(int i = 1; i < words.length; i++) {
            String word = wordList.get(wordList.size() - 1);
            if(word.charAt(word.length() - 1) == words[i].charAt(0)) {
                if(wordList.contains(words[i])) {
                    person = (i % n) + 1;
                    order = (i / n) + 1;
                    break;
                }
                else wordList.add(words[i]);
            }
            else {
                order = (i / n) + 1;
                person = (i % n) + 1;
                break;
            }
        }

        answer[0] = person;
        answer[1] = order;

        return answer;
    }
}