import java.io.*;
import java.util.*;

public class Main {
    private static int[] DX = new int[]{-1, 1, 0, 0};
    
    private static int[] DY = new int[]{0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        String[] arr = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        br.close();
        
        // solution;
        print(solution(N, M, arr));
    }
    
    private static int solution(int N, int M, String[] board) {
        int[][] map = new int[N][M];
        
        for (int j = 0; j < N; j++) {
            int[] raw = new int[M];
            
            String[] s = board[j].split("");
            
            for (int i = 0; i < s.length; i++) {
                raw[i] = Integer.parseInt(s[i]);
            }
            
            map[j] = raw;
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] vst = new boolean[N][M];
        
        q.offer(new int[]{0, 0, 1});
        
        vst[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == N - 1 && now[1] == M - 1) {
                return now[2];
            }
            
            for (int d = 0; d < 4; d++) {
                int y = now[0] + DY[d];
                
                int x = now[1] + DX[d];
                
                if (0 <= y && y < N && 0 <= x && x < M && !vst[y][x]) {
                    if (map[y][x] == 1) {
                        vst[y][x] = true;
                        
                        q.offer(new int[]{y, x, now[2] + 1});
                    }
                }
            }
        }
        
        return -1;
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