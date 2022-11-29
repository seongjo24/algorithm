package programmers.KAKAO_BLIND_RECRTUITMENT;

import java.util.*;

public class TaxiRide {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;


        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < fares.length; i++) {
            map.computeIfAbsent(fares[i][0], k -> new ArrayList<>()).add(new int[]{fares[i][1], fares[i][2]});
            map.computeIfAbsent(fares[i][1], k -> new ArrayList<>()).add(new int[]{fares[i][0], fares[i][2]});
        }

        int[] aArr = bfs(n, a, map);
        int[] bArr = bfs(n, b, map);
        int[] sArr = bfs(n, s, map);

        for (int i = 1; i <= n; i++) answer = Math.min(answer, aArr[i] + bArr[i] + sArr[i]);
        return answer;
    }

    public int[] bfs(int n, int a, Map<Integer, List<int[]>> map) {
        int[] visit = new int[n + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[a] = 0;
        q.add(a);
        int now = 0;

        while (q.size() > 0) {
            now = q.poll();

            for (int i = 0; i < map.get(now).size(); i++) {
                int next = map.get(now).get(i)[0];
                int val = map.get(now).get(i)[1];
                if (visit[now] + val < visit[next]) {
                    visit[next] = visit[now] + val;
                    q.add(next);
                }
            }
        }
        return visit;
    }
}
