
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        int[][] edges = new int[N - 1][2];
        
        for (int i = 0; i < N - 1; i++) {
            edges[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, edges));
    }
    
    private static int[] solution(int N, int[][] arr) {
        int[] answer = new int[N - 1];
        
        List<Set<Integer>> graph = new ArrayList<>(N + 1);
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int[] edge : arr) {
            int s = edge[0];
            
            int e = edge[1];
            
            graph.get(s).add(e);
            
            graph.get(e).add(s);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        Set<Integer> vst = new HashSet<>(N);
        
        q.offer(1);
        
        vst.add(1);
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            Set<Integer> children = graph.get(now);
            
            Iterator<Integer> it = children.iterator();
            
            while (it.hasNext()) {
                int node = it.next();
                
                if (vst.contains(node)) {
                    it.remove();
                } else {
                    q.offer(node);
                
                    vst.add(node);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            Set<Integer> children = graph.get(i);
            
            for (int node : children) {
                answer[node - 2] = i;
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