package programmers.practice;

import java.util.*;

public class UnitReturn {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] sum = new int[n + 1];
        int[] visit = new int[n + 1];
        int now = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        LinkedList<Integer> q = new LinkedList<Integer>();
        Arrays.fill(visit, -1);
        Arrays.fill(answer, -1);
        for (int i = 0; i < roads.length; i++) {
            graph.computeIfAbsent(roads[i][0], k -> new ArrayList<>()).add(roads[i][1]);
            graph.computeIfAbsent(roads[i][1], k -> new ArrayList<>()).add(roads[i][0]);
        }
        visit[destination] = 0;
        q.add(destination);
        while (q.size() != 0) {
            now = q.poll();
            for (Integer i : graph.get(now)) {
                if (visit[i] == -1) {
                    visit[i] = visit[now] + 1;
                    q.add(i);
                }
            }
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visit[sources[i]];
        }

        return answer;
    }
}
