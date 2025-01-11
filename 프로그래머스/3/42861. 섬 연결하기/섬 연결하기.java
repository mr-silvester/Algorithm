import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (c1, c2) -> {
            return Integer.compare(c1[2], c2[2]);
        });
        
        int[] roots = new int[n];
        
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        int e = 0;
        
        for (int[] c : costs) {
            if (e == n - 1) {
                break;
            }
            
            int i1 = c[0];
            
            int i2 = c[1];
            
            if (union(roots, i1, i2)) {
                e++;
                
                answer += c[2];
            }
        }
        
        return answer;
    }
    
    private boolean union(int[] roots, int i1, int i2) {
        int root1 = find(roots, i1);
        
        int root2 = find(roots, i2);
        
        if (root1 == root2) {
            return false;
        }
        
        if (root1 > root2) {
            update(roots, root1, root2);
            
            return true;
        }
        update(roots, root2, root1);
        
        return true;
    }
    
    private void update(int[] roots, int from, int to) {
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == from) {
                roots[i] = to;
            }
        }
    }
    
    private int find(int[] roots, int i) {
        int root = i;
        
        while (root != roots[root]) {
            root = roots[root];
        }
        
        return root;
    }
}