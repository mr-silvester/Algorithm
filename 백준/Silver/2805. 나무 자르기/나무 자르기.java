import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] input1 = br.readLine().split(" ");
        
        int N = Integer.parseInt(input1[0]);
        
        int M = Integer.parseInt(input1[1]);
        
        int[] trees = new int[N];
        
        String[] input2 = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(input2[i]);
        }
        
        br.close();
        
        int answer = solution(N, M, trees);
        
        System.out.print(answer);
    }
    
    public static int solution(int N, int M, int[] trees) {
        Arrays.sort(trees);
        
        int answer = 0;
        
        int left = 0;
        
        int right = trees[N - 1];
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (get(trees, mid) >= (long) M) {
                answer = mid;
                
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private static long get(int[] trees, int h) {
        long sum = 0;
        
        for (int tree : trees) {
            long diff = tree - h;
            
            if (diff > 0) {
                sum += diff;
            }
        }
        
        return sum;
    }
}