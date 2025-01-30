
import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] VE = intArr(br);
        
        int V = VE[0];
        
        int E = VE[1];
        
        int K = intNum(br);
        
        int[][] edges = new int[E][];
        
        for (int i = 0; i < E; i++) {
            edges[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        solution(V, E, K, edges);
    }
    
    private static void solution(int V, int E, int K, int[][] edges) {
        int[] min = new int[V + 1];
        
        for (int i = 1; i <= V; i++) {
            min[i] = INF;
        }
        
        min[K] = 0;
        
        List<List<int[]>> graph = new ArrayList<>(V + 1);
        
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            
            int e = edge[1];
            
            int w = edge[2];
            
            graph.get(s).add(new int[]{e, w});
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        
        q.add(new int[]{K, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            int node = now[0];
            
            for (int[] edge : graph.get(node)) {
                int e = edge[0];
                
                int curCost = min[e];
                
                int newCost = min[node] + edge[1];
                
                if (curCost > newCost) {
                    min[e] = newCost;
                    
                    q.add(new int[]{e, newCost});
                }
            }
        }
        
        for (int i = 1; i <= V; i++) {
            int val = min[i];
            
            if (val == INF) {
                System.out.println("INF");
            } else {
                System.out.println(val);
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