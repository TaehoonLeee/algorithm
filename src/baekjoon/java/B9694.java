package baekjoon.java;

import java.io.*;
import java.util.*;

public class B9694 {
    private static List<Relationship> relationshipList = new ArrayList<>();
    private static int[] dp;
    private static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            relationshipList.clear();
            dp = new int[m];
            path = new int[m];

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                relationshipList.add(new Relationship(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                ));
            }
            relationshipList.sort((o1, o2) -> {
                int compare = Integer.compare(o1.from, o2.from);
                if(o1.from == o2.from) {
                    compare = Integer.compare(o1.to, o2.to);
                }

                return compare;
            });

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for(int j = 0; j < n; j++) {
                Relationship relationship = relationshipList.get(j);
                if(dp[relationship.from] + relationship.degree < dp[relationship.to]) {
                    path[relationship.to] = relationship.from;
                }
                dp[relationship.to] = Math.min(dp[relationship.from] + relationship.degree,
                        dp[relationship.to]);
            }

            bw.write("Case #" + (i+1) + ":");
            if(dp[m-1] == Integer.MAX_VALUE) {
                bw.write(" -1\n");
            }
            else {
                int index = m-1;
                List<Integer> reversePath = new ArrayList<>();
                while (index != 0) {
                    reversePath.add(path[index]);
                    index = path[index];
                }
                Collections.reverse(reversePath);

                for (Integer integer : reversePath) {
                    bw.write(" " + integer);
                }
                bw.write(" " + (m-1));
                bw.write("\n");
            }
        }


        bw.flush();
        bw.close();
    }

    static class Relationship {
        int from, to, degree;

        Relationship(int _from, int _to, int _degree) {
            this.from = _from;
            this.to = _to;
            this.degree = _degree;
        }
    }
}
