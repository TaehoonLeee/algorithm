import java.util.Arrays;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {

        String s = "test";
        String answer = Arrays.stream(s.split(""))
                .sorted((o1, o2) -> {
                    int compare = Character.compare(o1.charAt(0), o2.charAt(0));
                    return compare;
                })
                .collect(Collectors.joining());
        System.out.println(answer);

    }
}
