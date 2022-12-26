package programmers.practice;

class SplitThePowerGridInTwo {
    boolean[][] edges;
    boolean[] visited;
    int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        int N = n + 1;
        edges = new boolean[N][N];
        visited = new boolean[N];
        for (int i = 0; i < wires.length; i++) {
            edges[wires[i][0]][wires[i][1]] = true;
            edges[wires[i][1]][wires[i][0]] = true;
        }
        for (int i = 0; i < wires.length; i++) {
            edges[wires[i][0]][wires[i][1]] = false;
            edges[wires[i][1]][wires[i][0]] = false;
            min = Math.min(min, Math.abs(dfs(wires[i][0]) - dfs(wires[i][1])));
            edges[wires[i][0]][wires[i][1]] = true;
            edges[wires[i][1]][wires[i][0]] = true;
        }
        return min;
    }


    public int dfs(int edge) {
        if (visited[edge]) {
            return 0;
        }
        visited[edge] = true;
        int cnt = 1;
        for (int i = 0; i < edges[edge].length; i++) {
            if (edges[edge][i])
                cnt += dfs(i);
        }
        visited[edge] = false;
        return cnt;
    }
}