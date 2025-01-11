import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 3 <= N <= 10,000
        int N = intNum(br);
        
        // 1 <= locals[i] <= 100,000
        int[] locals = intArr(br);
        
        // N <= M <= 1000,000,000
        int M = intNum(br);
        
        br.close();
        
        // solution;
        int answer = solution(N, locals, M);
        
        print(answer);
    }
    
    private static int solution(int N, int[] locals, int M) {
        int answer = 0;
        
        int left = 1;
        
        int right = M;
        
        int[] max = new int[]{0, 0};
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            // consumed, max
            int[] val = acceptable(locals, M, mid);
            
            if (val != null) {
                if (val[0] > max[0]) {
                    max = val;
                }
                
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return max[1];
    }
    
    private static int[] acceptable(int[] locals, int M, int upper) {
        int max = 0;
        
        int budget = M;
        
        for (int local : locals) {
            int need = Math.min(local, upper);
            
            if (budget - need < 0) {
                return null;
            }
            
            budget -= need;
            
            max = Math.max(max, need);
        }
        
        return new int[]{M - budget, max};
    }
    
    private static void print(int n) {
        System.out.print(n);
    }
    
    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        
        for (int n : arr) {
            sb.append(n).append(" ");
        }
        
        System.out.print(sb.toString());
    }
    
    private static void print(long[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        
        for (long n : arr) {
            sb.append(n).append(" ");
        }
        
        System.out.print(sb.toString());
    }
    
    private static void print(String[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        
        for (String s : arr) {
            sb.append(s).append(" ");
        }
        
        System.out.print(sb.toString());
    }
    
    private static int intNum(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
    
    private static int[] intArr(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        
        int[] result = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        
        return result;
    }
}