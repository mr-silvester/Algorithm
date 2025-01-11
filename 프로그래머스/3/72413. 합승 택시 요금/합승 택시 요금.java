class Solution {
    private static int INF;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        INF = 100000 * n + 1;
        
        int answer = INF;
        
        int[][] min = new int[n + 1][n + 1];
        
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i <= n; i++) {
                if (j == i) {
                    min[j][i] = 0;
                    
                    min[i][j] = 0;
                    
                    continue;
                }
                
                min[j][i] = INF;
            }
        }
        
        for (int[] fare : fares) {
            int from = fare[0];
            
            int to = fare[1];
            
            int cost = fare[2];
            
            min[from][to] = cost;
            
            min[to][from] = cost;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= n; i++) {
                    min[j][i] = Math.min(min[j][k] + min[k][i], min[j][i]);
                }
            }
        }
        
        for (int k = 1; k <= n; k++) {
            int cost = min[s][k] + min[k][a] + min[k][b];
            
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
}