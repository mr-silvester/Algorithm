import java.util.*;

class Solution {
    private static final int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        int[] costs = new int[n + 1];
        
        Arrays.fill(costs, INF);
        
        costs[destination] = 0;
        
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int p1 = road[0];
            
            int p2 = road[1];
            
            graph.get(p1).add(p2);
            
            graph.get(p2).add(p1);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        
        q.offer(new int[]{destination, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            List<Integer> edges = graph.get(now[0]);
            
            for (int node : edges) {
                int cost = costs[node];
                
                int newCost = costs[now[0]] + 1;
                
                if (newCost < cost) {
                    costs[node] = newCost;
                    
                    q.offer(new int[]{node, newCost});
                }
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            int s = sources[i];
            
            int cost = costs[s];
            
            if (cost == INF) {
                answer[i] = -1;
            } else {
                answer[i] = cost;
            }
        }
        
        return answer;
    }
}