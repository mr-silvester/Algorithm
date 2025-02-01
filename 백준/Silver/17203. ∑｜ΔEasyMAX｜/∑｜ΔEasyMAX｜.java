
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NQ = intArr(br);
        
        int N = NQ[0];
        
        int Q = NQ[1];
        
        int[] arr = intArr(br);
        
        int[][] ranges = new int[Q][2];
        
        for (int i = 0; i < Q; i++) {
            ranges[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        solution(N, Q, arr, ranges);
    }
    
    private static void solution(int N, int Q, int[] arr, int[][] ranges) {
        int[] sum = new int[N];
        
        for (int i = 0; i < N - 1; i++) {
            sum[i] = Math.abs(arr[i + 1] - arr[i]);
        }
        
        List<Long> arrSum = new ArrayList<>();
        
        arrSum.add(0L);
        
        for (int n : sum) {
            long prev = arrSum.get(arrSum.size() - 1);
            
            long val = prev + (long) n;
            
            arrSum.add(val);
        }
        
        for (int[] range : ranges) {
            int i = range[0];
            
            int j = range[1];
            
            if (j - 1 < i) {
                System.out.println(0);
                
                continue;
            }
            
            System.out.println(arrSum.get(j - 1) - arrSum.get(i - 1));
        }
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