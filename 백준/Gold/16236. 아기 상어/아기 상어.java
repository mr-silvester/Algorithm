import java.io.*;
import java.util.*;

public class Main {
    private static final int[] DY = new int[]{-1, 0, 1, 0};
    
    private static final int[] DX = new int[]{0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        int[][] input = new int[N][];
        
        for (int i = 0; i < N; i++) {
            input[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, input));
    }
    
    private static int solution(int N, int[][] input) {
        int answer = 0;
        
        int size = 2;
        
        int exp = 0;
        
        int[] now = new int[2];
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                int val = input[j][i];
                
                if (val == 9) {
                    now[0] = j;
                    
                    now[1] = i;
                    
                    input[j][i] = 0;
                    
                    break;
                }
            }
        }
        
        while (true) {
            int[] result = search(input, now, size);
            
            if (result == null) {
                break;
            }
            
            answer += result[2];
            
            now[0] = result[0];
            
            now[1] = result[1];
            
            input[now[0]][now[1]] = 0;
            
            exp++;
            
            if (exp == size) {
                size++;
                
                exp  = 0;
            }
        }
        
        return answer;
    }
    
    private static int[] search(int[][] input, int[] now, int size) {
        int[] result = new int[3];
        
        result[2] = Integer.MAX_VALUE;
        
        for (int j = 0; j < input.length; j++) {
            for (int i = 0; i < input.length; i++) {
                int fish = input[j][i];
                
                if (0 < fish && fish < size) {
                    int cost = bfs(input, j, i, now[0], now[1], size);
                    
                    if (cost == 0) {
                        continue;
                    }
                    
                    if (result[2] > cost) {
                        result[0] = j;
                        
                        result[1] = i;
                        
                        result[2] = cost;
                    }
                }
            }
        }
        
        if (result[2] == Integer.MAX_VALUE) {
            return null;
        }
        
        return result;
    }
    
    private static int bfs(int[][] input, int j1, int i1, int j2, int i2, int size) {
        boolean[][] vst = new boolean[input.length][input.length];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{j1, i1, 0});
        
        vst[j1][i1] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == j2 && now[1] == i2) {
                return now[2];
            }
            
            for (int d = 0; d < 4; d++) {
                int y = now[0] + DY[d];
                
                int x = now[1] + DX[d];
                
                if (0 <= y && y < input.length && 0 <= x && x < input.length) {
                    if (vst[y][x]) {
                        continue;
                    }
                    
                    if (input[y][x] > size) {
                        continue;
                    }
                    
                    q.offer(new int[]{y, x, now[2] + 1});
                    
                    vst[y][x] = true;
                }
            }
        }
        
        return 0;
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