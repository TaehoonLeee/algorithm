package programmers.java;

import java.util.*;

class TravelPath {
    private static List<String> path;
    private static boolean[] visited;
    private static String[] pre;
    private static String[] post;

    public String[] solution(String[][] tickets) {
        path = new ArrayList<>();
        visited = new boolean[tickets.length];
        pre = new String[tickets.length+1];
        post = new String[tickets.length+1];

        for(int i = 0; i < tickets.length+1; i++) {
            pre[i] = "";
            post[i] = "";
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals("ICN")) {
                visited[i] = true;
                dfs(i, tickets, 0);
                path.clear();
                visited[i] = false;
            }
        }

        return pre;
    }

    private static void dfs(int from, String[][] tickets, int depth) {
        path.add(tickets[from][0]);

        if(path.size() == tickets.length) {
            if(pre[0].isEmpty()) {
                for(int i = 0; i < tickets.length; i++) {
                    pre[i] = path.get(i);
                }
                pre[tickets.length] = tickets[from][1];
            }
            else {
                for(int i = 0; i < tickets.length; i++) {
                    post[i] = path.get(i);
                }
                post[tickets.length] = tickets[from][1];
            }

            if(!pre[0].isEmpty() && !post[0].isEmpty()) {
                for(int i = 0; i < tickets.length+1; i++) {
                    if(pre[i].compareTo(post[i]) > 0) {
                        for(int j = 0; j < tickets.length+1; j++) {
                            pre[j] = post[j];
                        }
                        for(int j = 0; j < tickets.length+1; j++) {
                            System.out.println(pre[j]);
                        }
                        break;
                    }
                    else if(pre[i].compareTo(post[i]) < 0) break;
                }
            }

            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(tickets[from][1].equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(i, tickets, depth+1);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
