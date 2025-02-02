import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] RCQ = intArr(br);
        
        int R = RCQ[0];
        
        int C = RCQ[1];
        
        int Q = RCQ[2];
        
        int[][] photo = new int[R][];
        
        for (int i = 0; i < R; i++) {
            photo[i] = intArr(br);
        }
        
        int[][] squares = new int[Q][];
        
        for (int i = 0; i < Q; i++) {
            squares[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        solution(R, C, Q, photo, squares);
    }
    
    private static void solution(int R, int C, int Q, int[][] photo, int[][] squares) {
        int[][] sum = new int[R][C];
        
        for (int j = 0; j < R; j++) {
            sum[j][0] = photo[j][0];
            
            for (int i = 1; i < C; i++) {
                sum[j][i] = sum[j][i - 1] + photo[j][i];
            }
        }
        
        for (int[] square : squares) {
            int avg = avg(R, C, Q, sum, square);
            
            System.out.println(avg);
        }
    }
    
    private static int avg(int R, int C, int Q, int[][] sum, int[] square) {
        int total = 0;
        
        int y1 = square[0] - 1;
        
        int x1 = square[1] - 1;
        
        int y2 = square[2] - 1;
        
        int x2 = square[3] - 1;
        
        for (int j = y1; j <= y2; j++) {
            total += sum[j][x2];
            
            if (x1 - 1 >= 0) {
                total -= sum[j][x1 - 1];
            }
        }
        
        int count = (y2 - y1 + 1) * (x2 - x1 + 1);
        
        return total / count;
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