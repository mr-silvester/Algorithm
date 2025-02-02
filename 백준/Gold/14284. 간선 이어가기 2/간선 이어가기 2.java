import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        int[][] edges = new int[M][];
        
        for (int i = 0; i < M; i++) {
            edges[i] = intArr(br);
        }
        
        int[] st = intArr(br);
        
        int s = st[0];
        
        int t = st[1];
        
        br.close();
        
        // solution;
        print(solution(N, M, edges, s, t));
    }
    
    private static int solution(int N, int M, int[][] edges, int s, int t) {
        List<List<int[]>> graph = new ArrayList<>(N + 1);
        
        int[] min = new int[N + 1];
        
        Arrays.fill(min, Integer.MAX_VALUE);
        
        min[s] = 0;
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            
            int to = edge[1];
            
            int cost = edge[2];
            
            graph.get(from).add(new int[]{to, cost});
            
            graph.get(to).add(new int[]{from, cost});
        }
        
        boolean[] vst = new boolean[N + 1];
        
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        
        q.add(new int[]{s, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            int node = now[0];
            
            for (int[] edge : graph.get(node)) {
                int to = edge[0];
                
                int originalCost = min[to];
                
                int newCost = min[node] + edge[1];
                
                if (originalCost > newCost) {
                    min[to] = newCost;
                    
                    q.add(new int[]{to, newCost});
                }
            }
        }
        
        return min[t];
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