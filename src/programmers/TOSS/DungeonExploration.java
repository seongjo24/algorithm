package programmers.TOSS;

public class DungeonExploration {
    int max;

    public void dfs(int k, int[][] dungeons, boolean[] visited, int depth) {
        if (max == dungeons.length) return;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                int tmpK = k;
                if (tmpK < dungeons[i][0]) continue;
                else tmpK -= dungeons[i][1];
                visited[i] = true;
                max = Integer.max(max, depth + 1);
                dfs(tmpK, dungeons, visited, depth + 1);
                visited[i] = false;
            }

        }

    }


    public int solution(int k, int[][] dungeons) {
        max = 0;
        for (int i = 0; i < dungeons.length; i++) {
            int tmpK = k;
            boolean[] visited = new boolean[dungeons.length];
            if (tmpK < dungeons[i][0]) continue;
            else tmpK -= dungeons[i][1];
            visited[i] = true;
            max = Integer.max(max, 1);
            dfs(tmpK, dungeons, visited, 1);
        }
        return max;
    }


}
