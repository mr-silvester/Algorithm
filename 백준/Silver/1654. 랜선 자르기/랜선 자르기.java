import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line1 = br.readLine().split(" ");
        
        // 1 <= K <= 10000
        int K = Integer.parseInt(line1[0]);
        
        // 1 <= N <= 1000000
        int N = Integer.parseInt(line1[1]);
        
        int[] lines = new int[K];
        
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
        
        // solution;
        long answer = solution(K, N, lines);
        
        System.out.print(answer);
    }
    
    private static long solution(int K, int N, int[] lines) {
        long answer = Integer.MAX_VALUE;
        
        long left = 1;
        
        long right = Integer.MAX_VALUE;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (cut(lines, mid) >= N) {
                answer = mid;
                
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private static long cut(int[] lines, long len) {
        long count = 0;
        
        for (int line : lines) {
            count += line / len;
        }
        return count;
    }
}