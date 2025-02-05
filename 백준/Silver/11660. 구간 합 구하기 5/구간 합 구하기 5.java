import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        int[][] board = new int[N][];
        
        for (int i = 0; i < N; i++) {
            board[i] = intArr(br);
        }
        
        int[][] coors = new int[M][];
        
        for (int i = 0; i < M; i++) {
            coors[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        solution(N, M, board, coors);
    }
    
    private static void solution(int N, int M, int[][] board, int[][] coors) {
        int[][] sum = new int[N][N];
        
        for (int j = 0; j < N; j++) {
            sum[j][0] = board[j][0];
            
            for (int i = 1; i < N; i++) {
                sum[j][i] = sum[j][i - 1] + board[j][i];
            }
        }
        
        for (int[] coor : coors) {
            int x1 = coor[0];
            
            int y1 = coor[1];
            
            int x2 = coor[2];
            
            int y2 = coor[3];
            
            int result = run(N, M, sum, x2, y2, x1, y1);
            
            System.out.println(result);
        }
    }
    
    private static int run(int N, int M, int[][] sum, int y2, int x2, int y1, int x1) {
        int answer = 0;
    
        int j2 = y2 - 1;
        
        int i2 = x2 - 1;
        
        int j1 = y1 - 1;
        
        int i1 = x1 - 1;
        
        for (int j = j1; j <= j2; j++) {
            answer += sum[j][i2];
            
            if (i1 - 1 >= 0) {
                answer -= sum[j][i1 - 1];
            }
        } 
        
        return answer;
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