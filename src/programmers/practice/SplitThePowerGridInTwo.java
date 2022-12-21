package programmers.practice;

import java.util.*;
class SplitThePowerGridInTwo {
    int min;
    int N;
    boolean[][] edges;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        N=n+1;
        edges = new boolean[N][N];
        visited= new boolean[N];
        int min= Integer.MAX_VALUE;
        for(int i =0;i<wires.length;i++){

            int a= wires[i][0];
            int b= wires[i][1];
            edges[a][b]=true;
            edges[b][a]=true;
        }
        for(int i =0;i<wires.length;i++){
            Arrays.fill(visited, false);
            int a= wires[i][0];
            int b= wires[i][1];
            edges[a][b]=false;
            edges[b][a]=false;

            int aCnt= dfs(a,0);
            int bCnt= dfs(b,0);
            min= Math.min(min,Math.abs(aCnt-bCnt));
            edges[a][b]=true;
            edges[b][a]=true;

        }

        return min;
    }

    public int dfs(int cur,int cnt){
        if(visited[cur]) return 0;

        visited[cur]=true;

        int sum = 1;

        for(int i=0; i<N;i++){
            if(!edges[cur][i]){
                continue;
            }
            sum+=dfs(i,cnt+1);
        }
        visited[cur] = false;
        return sum;
    }
}