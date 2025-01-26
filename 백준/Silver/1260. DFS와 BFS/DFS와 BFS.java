
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NMV = intArr(br);
        
        int N = NMV[0];
        
        int M = NMV[1];
        
        int V = NMV[2];
        
        int[][] arr = new int[M][2];
        
        for (int i = 0; i < M; i++) {
            arr[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        solution(N, M, V, arr);
    }
    
    private static void solution(int N, int M, int V, int[][] lines) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] line : lines) {
            int from = line[0];
            
            int to = line[1];
            
            graph.get(from).add(to);
            
            graph.get(to).add(from);
        }
        
        for (List<Integer> edges : graph) {
            Collections.sort(edges);
        }
        
        dfs(N, M, V, graph);
        
        System.out.println();
        
        bfs(N, M, V, graph);
    }
    
    private static void dfs(int N, int M, int V, List<List<Integer>> graph) {
        List<Integer> answer = new ArrayList<>();
        
        boolean[] vst = new boolean[N + 1];
        
        visit(V, graph, vst);
    }
    
    private static void visit(int now, List<List<Integer>> graph, boolean[] vst) {
        System.out.print(now + " ");
        
        vst[now] = true;
        
        for (int next : graph.get(now)) {
            if (!vst[next]) {
                visit(next, graph, vst);
            }
        }
    }
    
    private static void bfs(int N, int M, int V, List<List<Integer>> graph) {
        boolean[] vst = new boolean[N + 1];
        
        Queue<Integer> q = new LinkedList<>();
        
        List<Integer> answer = new ArrayList<>();
        
        q.add(V);
        
        vst[V] = true;
        
        answer.add(V);
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : graph.get(now)) {
                if (!vst[next]) {
                    q.add(next);
                    
                    answer.add(next);
                    
                    vst[next] = true;
                }
            }
        }
        
        for (int num : answer) {
            System.out.print(num + " ");
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