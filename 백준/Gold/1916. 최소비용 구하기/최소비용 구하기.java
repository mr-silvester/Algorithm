
import java.io.*;
import java.util.*;

public class Main {
    private static final long INF = Long.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = intNum(br);
        
        int M = intNum(br);
        
        long[][] edges = new long[M][];
        
        for (int i = 0; i < M; i++) {
            edges[i] = longArr(br);
        }
        
        int[] SE = intArr(br);
        
        int S = SE[0];
        
        int E = SE[1];
        
        br.close();
        
        // solution;
        solution(N, M, edges, S, E);
    }
    
    private static void solution(int N, int M, long[][] edges, int S, int E) {
        long[] min = new long[N + 1];
        
        Arrays.fill(min, INF);
        
        min[S] = 0;
        
        List<List<long[]>> graph = new ArrayList<>(N + 1);
        
        boolean[] vst = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (long[] edge : edges) {
            long s = edge[0];
            
            long e = edge[1];
            
            long cost = edge[2];
            
            graph.get((int) s).add(new long[]{e, cost});
        }
        
        PriorityQueue<long[]> q = new PriorityQueue<>((e1, e2) -> {
            return Long.compare(e1[1], e2[1]);
        });
        
        q.add(new long[]{S, 0});
        
        while (!q.isEmpty()) {
            long[] now = q.poll();
            
            long node = now[0];
            
            if (vst[(int) node]) {
                continue;
            }
            
            vst[(int) node] = true;
            
            for (long[] edge : graph.get((int) node)) {
                long e = edge[0];
                
                long curCost = min[(int) e];
                
                long newCost = min[(int) node] + edge[1];
                
                if (curCost > newCost) {
                    min[(int) e] = newCost;
                    
                    q.add(new long[]{e, newCost});
                }
            }
        }
        
        System.out.print(min[E]);
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