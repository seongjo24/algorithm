package programmers.practice;
//https://school.programmers.co.kr/learn/courses/30/lessons/12902
class Tailling {
    public int solution(int n) {
        int answer = 0;
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3; i <= n; i++){
            if(i%2 == 0){

                dp[i] = dp[i-1]%mod + dp[i-2]%mod;
            } else {

                dp[i] = dp[i-1]*2%mod + dp[i-2]%mod;
            }
            dp[i] = dp[i]%mod;
        }
        return dp[n];
    }
}