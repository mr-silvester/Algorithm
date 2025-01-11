class Solution {
    private static final int DIV = 10007;
    
    public int solution(int n, int[] tops) {    
        int answer = 0;
        
        int[] t = {3, 4};
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        dp[1] = t[tops[0]];
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] * t[tops[i - 1]] - dp[i - 2]) % DIV;
            
            if (dp[i] < 0) {
                dp[i] += DIV;
            }
        }
        
        return dp[n] % DIV;
    }
}