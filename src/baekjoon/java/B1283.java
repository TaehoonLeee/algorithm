package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        macro = new String[N];
        for(int i = 0; i < N; i++) {
            macro[i] = br.readLine();
        }

        alphabet.add(macro[0].substring(0, 1));
        for(int i = 1; i < N; i++) {
            inserted = false;
            String[] words = macro[i].split(" ");

            for(int j = 0; j < words.length; j++) {
                duplicated = false;
                String capital = words[j].substring(0, 1);

                for(int k = 0; k < alphabet.size(); k++) {
                    if(capital.equalsIgnoreCase(alphabet.get(k))) {
                        duplicated = true;
                        break;
                    }
                }
                if(!duplicated) {
                    macro[i] = macro[i].replaceFirst(capital, "["+capital+"]");
                    alphabet.add(capital);
                    inserted = true;
                    break;
                }
            }

            if(!inserted) {
                for(int j = 0; j < macro[i].length(); j++) {
                    duplicated = false;
                    String word = macro[i].substring(j, j+1);
                    if(word.equalsIgnoreCase(" ")) continue;

                    for(int k = 0; k < alphabet.size(); k++) {
                        if(word.equalsIgnoreCase(alphabet.get(k))) {
                            duplicated = true;
                            break;
                        }
                    }
                    if(!duplicated) {
                        alphabet.add(word);
                        macro[i] = macro[i].replaceFirst(word, "["+word+"]");
                        break;
                    }
                }
            }
        }

        macro[0] = macro[0].replaceFirst(macro[0].substring(0, 1), "["+macro[0].substring(0, 1)+"]");
        for(int i = 0; i < macro.length; i++) {
            System.out.println(macro[i]);
        }
    }

    private static int N;
    private static String[] macro;
    private static List<String> alphabet = new ArrayList<>();
    private static boolean inserted = false;
    private static boolean duplicated = false;
}