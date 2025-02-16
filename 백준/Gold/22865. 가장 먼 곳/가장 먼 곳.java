import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        int[] ABC = intArr(br);
        
        int M = intNum(br);
        
        int[][] edges = new int[M][];
        
        for (int i = 0; i < M; i++) {
            edges[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, ABC, M, edges));
    }
    
    private static int solution(int N, int[] ABC, int M, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>(N + 1);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            
            int e = edge[1];
            
            int w = edge[2];
            
            graph.get(s).add(new int[]{e, w});
            
            graph.get(e).add(new int[]{s, w});
        }
        
        long[] a = dijk(N, graph, ABC[0]);
        
        long[] b = dijk(N, graph, ABC[1]);
        
        long[] c = dijk(N, graph, ABC[2]);
        
        int x = 0;
        
        long distance = 0;
        
        for (int i = 1; i <= N; i++) {
            long d = Math.min(a[i], Math.min(b[i], c[i]));
            
            if (d > distance) {
                distance = d;
                
                x = i;
            }
        }
        
        return x;
    }
    
    private static long[] dijk(int N, List<List<int[]>> graph, int start) {
        long[] result = new long[N + 1];
        
        Arrays.fill(result, Long.MAX_VALUE);
        
        result[start] = 0;
        
        PriorityQueue<long[]> q = new PriorityQueue<>((e1, e2) -> {
            return Long.compare(e1[1], e2[1]);
        });
        
        //boolean[] vst = new boolean[N + 1];
        
        q.offer(new long[]{start, 0});
        
        //vst[start] = true;
        
        while (!q.isEmpty()) {
            long[] now = q.poll();
            
            int node = (int) now[0];
            
            long cost = now[1];
            
            /*
            if (vst[node]) {
                continue;
            }
            
            vst[node] = true;*/
            
            for (int[] edge : graph.get(node)) {
                int e = edge[0];
                
                int w = edge[1];
                
                long originalCost = result[e];
                
                long newCost = cost + w;
                
                if (originalCost > newCost) {
                    result[e] = newCost;
                    
                    q.offer(new long[]{e, newCost});
                }
            }
        }
        
        return result;
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