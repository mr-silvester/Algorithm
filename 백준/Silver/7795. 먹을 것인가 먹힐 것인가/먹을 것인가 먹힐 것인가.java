import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = intNum(br);
        
        int[][][] tests = new int[T][3][];
        
        for (int t = 0; t < T; t++) {
            // N, M
            tests[t][0] = intArr(br);
            
            // A
            tests[t][1] = intArr(br);
            
            // B
            tests[t][2] = intArr(br);
            
            Arrays.sort(tests[t][2]);
        }
        
        br.close();
        
        // solution;
        int[] answer = solution(T, tests);
        
        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
    
    private static int[] solution(int T, int[][][] tests) {
        int[] answer = new int[T];
        
        for (int t = 0; t < T; t++) {
            answer[t] = test(tests[t]);
        }
        
        return answer;
    }
    
    private static int test(int[][] test) {
        int answer = 0;
        
        int[] A = test[1];
        
        // sorted
        int[] B = test[2];
        
        for (int a : A) {
            answer += search(a, B) + 1;
        }
        
        return answer;
    }
    
    private static int search(int a, int[] B) {
        int idx = -1;
        
        int left = 0;
        
        int right = B.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int b = B[mid];
            
            if (a > b) {
                idx = mid;
                
                left = mid + 1;
            } else {
                right = mid  - 1;
            }
        }
        
        return idx;
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