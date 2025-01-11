class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int len = sequence.length;
        
        if (len == 1) {
            return ((long) Math.abs((long) sequence[0]));
        }
        
        long[] p1 = new long[len];
        
        for (int i = 0; i < len; i++) {
            long sign = i % 2 == 0 ? -1 : 1;
            
            p1[i] = ((long) sequence[i] * sign);
        }
        
        long[] sum1 = new long[len + 1];
        
        sum1[0] = 0;
        
        long max1 = sum1[0];
        
        long min1 = sum1[0];
        
        for (int i = 1; i < len + 1; i++) {
            sum1[i] = sum1[i - 1] + p1[i - 1];
            
            max1 = Math.max(max1, sum1[i]);
            
            min1 = Math.min(min1, sum1[i]);
        }
        
        return max1 - min1;
    }
}