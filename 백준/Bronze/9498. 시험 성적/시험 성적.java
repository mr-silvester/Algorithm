import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        br.close();
        
        // solution;
        System.out.print(solution(N));
    }
    
    private static String solution(int N) {
        if (N >= 90) {
            return "A";
        }
        if (N >= 80) {
            return "B";
        }
        if (N >= 70) {
            return "C";
        }
        if (N >= 60) {
            return "D";
        }
        return "F";
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