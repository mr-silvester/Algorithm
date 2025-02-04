import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = intNum(br);
        
        for (int t = 0; t < T; t++) {
            int[] NM = intArr(br);
            
            int N = NM[0];
            
            int M = NM[1];
            
            int[][] edges = new int[M][];
            
            for (int i = 0; i < M; i++) {
                edges[i] = intArr(br);
            }
            
            int K = intNum(br);
            
            int[] P = intArr(br);
            
            System.out.println(solution(N, M, edges, K, P));
        }
        
        br.close();
    }
    
    private static int solution(int N, int M, int[][] edges, int K, int[] P) {
        int[][] min = new int[N + 1][N + 1];
        
        for (int j = 1; j <= N; j++) {
            for (int i =1; i <= N; i++) {
                if (i == j) {
                    continue;
                }
                
                min[j][i] = 10000001;
            }
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            
            int e = edge[1];
            
            int d = edge[2];
            
            min[s][e] = d;
            
            min[e][s] = d;
        }
        
        for (int k = 1; k <= N; k++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    min[s][e] = Math.min(min[s][k] + min[k][e], min[s][e]);
                }
            }
        }
        
        int dis = 10000001;
        
        int room = -1;
        
        for (int i = 1; i <= N; i++) {
            int cost = 0;
            
            for (int p : P) {
                cost += min[i][p];
            }
            
            if (cost < dis) {
                dis = cost;
                
                room = i;
            }
        }
        
        return room;
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