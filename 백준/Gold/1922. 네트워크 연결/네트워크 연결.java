import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        int M = intNum(br);
        
        int[][] edges = new int[M][];
        
        for (int i = 0; i < M; i++) {
            edges[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, M, edges));
    }
    
    private static int solution(int N, int M, int[][] edges) {
        int answer = 0;
        
        int[] roots = new int[N + 1];
        
        /* union - find 초기화 */
        for (int i = 1; i <= N; i++) {
            roots[i] = i;
        }
        
        /* 엣지 비용 오름차순으로 정렬 */
        Arrays.sort(edges, (e1, e2) -> {
            return Integer.compare(e1[2],  e2[2]);
        });
        
        int count = 0;
        
        for (int[] edge : edges) {
            if (count >= N - 1) {
                break;
            }
            
            int i1 = edge[0];
            
            int i2 = edge[1];
            
            int cost = edge[2];
            
            boolean success = union(roots, i1, i2);
            
            if (success) {
                count++;
                
                answer += cost;
            }
        }
        
        return answer;
    }
    
    private static int find(int[] roots, int i) {
        int parent = roots[i];
        
        if (parent == i) {
            return i;
        }
        
        int root = find(roots, parent);
        
        roots[i] = root;
        
        return root;
    }
    
    private static boolean union(int[] roots, int i1, int i2) {
        int root1 = find(roots, i1);
        
        int root2 = find(roots, i2);
        
        if (root1 == root2) {
            return false;
        }
        
        if (root1 < root2) {
            roots[root2] = root1;
        } else {
            roots[root1] = root2;
        }
        
        return true;
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