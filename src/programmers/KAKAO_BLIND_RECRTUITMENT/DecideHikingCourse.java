package programmers.KAKAO_BLIND_RECRTUITMENT;
import java.util.*;
public class DecideHikingCourse {

    static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int idx;
        List<DecideHikingCourse.Edge> edgeList = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }
    }

    private static class Edge implements Comparable<DecideHikingCourse.Edge> {
        DecideHikingCourse.Node from;
        DecideHikingCourse.Node to;
        int weight;

        public Edge(DecideHikingCourse.Node from, DecideHikingCourse.Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(DecideHikingCourse.Edge o) {
            return this.weight - o.weight;
        }
    }

    List<DecideHikingCourse.Node> nodeList = new ArrayList<>();
    Set<Integer> summitSet = new HashSet<>();
    Set<Integer> gateSet = new HashSet<>();
    PriorityQueue<DecideHikingCourse.Edge> queue = new PriorityQueue<>();
    int[] dp;
    int ans;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {


        for(int i = 0; i <= n; i++) {
            nodeList.add(new DecideHikingCourse.Node(i));
        }
        for (int[] path : paths) {
            DecideHikingCourse.Node from = nodeList.get(path[0]);
            DecideHikingCourse.Node to = nodeList.get(path[1]);


            DecideHikingCourse.Edge fromEdge = new DecideHikingCourse.Edge(from, to, path[2]);
            DecideHikingCourse.Edge toEdge = new DecideHikingCourse.Edge(to, from, path[2]);

            from.edgeList.add(fromEdge);
            to.edgeList.add(toEdge);
        }

        for (int gate : gates) {
            gateSet.add(gate);
        }
        for (int summit : summits) {
            summitSet.add(summit);
        }

        ans = INF;
        int min = INF;
        int ansIdx = 0;
        Arrays.sort(summits);
        dp = new int[nodeList.size()];

        for (int summit : summits) {
            DecideHikingCourse.Node v = nodeList.get(summit);
            dfs(v);
            for (int gate : gates) {
                min = Math.min(min, dp[gate]);
            }
            if(min < ans) {
                ans = min;
                ansIdx = summit;
            }
        }
        return new int[]{ansIdx, ans};
    }

    private void dfs(DecideHikingCourse.Node v) {
        Arrays.fill(dp, INF);
        dp[v.idx] = 0;

        queue.clear();


        for (DecideHikingCourse.Edge edge : v.edgeList) {

            if(summitSet.contains(edge.to.idx)) continue;


            if(ans < edge.weight) continue;


            dp[edge.to.idx] = edge.weight;
            queue.add(edge);
        }

        while(!queue.isEmpty()) {

            DecideHikingCourse.Edge w = queue.poll();


            if(dp[w.to.idx] < w.weight) continue;


            for (DecideHikingCourse.Edge edge : w.to.edgeList) {

                if(summitSet.contains(edge.to.idx)) continue;


                int maxIntensity = Math.max(dp[w.to.idx], edge.weight);


                if(maxIntensity < dp[edge.to.idx]) {
                    dp[edge.to.idx] = maxIntensity;

                    if(!gateSet.contains(edge.to.idx)) {
                        queue.add(edge);
                    }
                }
            }
        }
    }
}
