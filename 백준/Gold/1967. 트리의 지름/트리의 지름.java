import java.io.*;
import java.util.*;

public class Main {
    private static int MAX_SUM = 0;
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        int[][] edges = new int[N - 1][];
        
        for (int i = 0; i < N - 1; i++) {
            edges[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, edges));
    }
    
    private static int solution(int N, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>(N + 1);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            
            int e = edge[1];
            
            int w = edge[2];
            
            graph.get(s).add(new int[]{e, w});
        }
        
        int answer = search(graph, 1);
        
        return Math.max(answer, MAX_SUM);
    }
    
    private static int search(List<List<int[]>> graph, int node) {
        int max = 0;
        
        List<Integer> weights = new ArrayList<>();
        
        for (int[] edge : graph.get(node)) {
            int child = edge[0];
            
            int w = edge[1] + search(graph, child);
            
            max = Math.max(max, w);
            
            weights.add(w);
        }
        
        comb(weights);
        
        return max;
    }
    
    private static void comb(List<Integer> weights) {
        for (int i = 0; i < weights.size() - 1; i++) {
            for (int j = i + 1; j < weights.size(); j++) {
                int w = weights.get(i) + weights.get(j); 
                
                MAX_SUM = Math.max(MAX_SUM, w);
            }
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