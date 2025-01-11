class Solution {
    private static final long C = 1000000007;
    
    public int solution(int n, int[] money) {
        long[] dp = new long[n + 1];
        
        dp[0] = 1;
        
        for (int k : money) {
            process(dp, k);
        }
        
        return (int) dp[n];
    }
    
    void process(long[] dp, int k) {
        for (int i = k; i < dp.length; i++) {
            dp[i] += dp[i - k] % C;
        }
    }
}