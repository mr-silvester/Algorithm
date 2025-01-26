import java.util.*;

class Solution {
    private static final String U = "U";
    
    private static final String D = "D";
    
    private static final String C = "C";
    
    private static final String Z = "Z";
    
    private static final String O = "O";
    
    private static final String X = "X";
    
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        
        int[] next = new int[n];
        
        boolean[] removed = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            
            if (i + 1 >= n) {
                next[i] = -1;
            } else {
                next[i] = i + 1;
            }
        }
        
        int now = k;
        
        Stack<Integer> stack = new Stack<>();
        
        for (String prompt : cmd) {
            String[] q = prompt.split(" ");
            
            String type = q[0];
            
            if (type.equals(U)) {
                int x = Integer.parseInt(q[1]);
                
                now = prev(prev, now, x);
                
                continue;
            }
            
            if (type.equals(D)) {
                int x = Integer.parseInt(q[1]);
                
                now = next(next, now, x);
                
                continue;
            }
            
            if (type.equals(C)) {
                stack.push(now);
                
                now = remove(prev, next, removed, now);
                
                continue;
            }
            
            if (type.equals(Z)) {
                int z = stack.pop();
                
                undo(prev, next, removed, z);
                
                continue;
            }
        }
        
        StringBuilder sb = new StringBuilder(n);
        
        for (boolean val : removed) {
            if (val) {
                sb.append(X);
            } else {
                sb.append(O);
            }
        }
        
        return sb.toString();
    }
    
    private void undo(int[] prev, int[] next, boolean[] removed, int z) {
        int prevIdx = prev[z];
        
        int nextIdx = next[z];
        
        if (prevIdx > -1) {
            next[prevIdx] = z;
        }
        
        if (nextIdx > -1) {
            prev[nextIdx] = z;
        }
        
        removed[z] = false;
    }
    
    private int remove(int[] prev, int[] next, boolean[] removed, int now) {
        removed[now] = true;
        
        int prevIdx = prev[now];
        
        int nextIdx = next[now];
        
        if (prevIdx > -1) {
            next[prevIdx] = nextIdx;
        }
        
        if (nextIdx > -1) {
            prev[nextIdx] = prevIdx;
        }
        
        int idx = next(next, now, 1);
        
        if (idx == now) {
            return prev(prev, now, 1);
        }
        
        return idx;
    }
    
    private int next(int[] next, int now, int x) {
        int i = now;
        
        while (x > 0) {
            if (next[now] < 0) {
                break;
            }
            
            x--;
            
            i = next[now];
            
            now = i;
        }
        
        return now;
    }
    
    private int prev(int[] prev, int now, int x) {
        int i = now;
        
        while (x > 0) {
            if (prev[now] < 0) {
                break;
            }
            
            x--;
            
            i = prev[now];
            
            now = i;
        }
        
        return now;
    }
}