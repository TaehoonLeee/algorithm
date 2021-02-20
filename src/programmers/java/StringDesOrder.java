package programmers.java;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class StringDesOrder {
    public String solution(String s) {
        String answer = Arrays.stream(s.split(""))
                .sorted( (o1, o2) -> {
                    int compare = Character.compare(o2.charAt(0), o1.charAt(0));
                    return compare;
                })
                .collect(Collectors.joining());

        return answer;
    }
}