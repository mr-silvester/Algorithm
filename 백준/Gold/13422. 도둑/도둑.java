import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = intNum(br);
        
        int[][][] tests = new int[T][][];
        
        for (int t = 0; t < T; t++) {
            tests[t] = new int[2][];
            
            tests[t][0] = intArr(br);
            
            tests[t][1] = intArr(br);
        }
        
        br.close();
        
        // solution;
        solution(T, tests);
    }
    
    private static void solution(int T, int[][][] tests) {
        for (int t = 0; t < T; t++) {
            int[][] test = tests[t];
            
            test(test);
        }
    }
    
    private static void test(int[][] test) {
        int answer = 0;
        
        int N = test[0][0];
        
        int M = test[0][1];
        
        int K = test[0][2];
        
        int[] houses = new int[N + M - 1];
        
        for (int i = 0; i < N; i++) {
            houses[i] = test[1][i];
        }
        
        for (int i = 0; i < M - 1; i++) {
            houses[N + i] = test[1][i];
        }
        
        int sum = 0;
        
        int e = M - 1;
        
        for (int i = 0; i < M - 1; i++) {
            sum += houses[i];
        }
        
        // 슬라이딩 윈도우
        for (int s = 0; s < test[1].length; s++) {
            sum += houses[e];
            
            if (sum < K) {
                answer++;
            }
            
            if (N == M) {
                break;
            }
            
            sum -= houses[s];
            
            e++;
        }
        
        System.out.println(answer);
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
    
    private static void println(long[] arr) {
        for (long n : arr) {
            System.out.println(n);
        }
    }
    
    private static void print(String[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        
        for (String s : arr) {
            sb.append(s).append(" ");
        }
        
        System.out.print(sb.toString());
    }
    
    
    private static String[] strArr(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
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
    
    private static long longNum(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }
    
    private static long[] longArr(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        
        long[] result = new long[input.length];
        
        for (int i = 0; i < input.length; i++) {
            result[i] = Long.parseLong(input[i]);
        }
        
        return result;
    }
}