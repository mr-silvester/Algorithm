import java.io.*;
import java.util.*;

public class Main {
    private static int[] DX = new int[]{-1, 1, 0, 0};
    
    private static int[] DY = new int[]{0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        String[] arr = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        br.close();
        
        // solution;
        print(solution(N, arr));
    }
    
    private static int[] solution(int N, String[] board) {
        int[] answer = new int[2];
        
        String[][] map = new String[N][];
        
        for (int i = 0; i < N; i++) {
            map[i] = board[i].split("");
        }
        
        answer[0] = search(N, map);
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (map[j][i].equals("R")) {
                    map[j][i] = "G";
                }
            }
        }
        
        answer[1] = search(N, map);
        
        return answer;
    }
    
    private static int search(int N, String[][] map) {
        int answer = 0;
        
        boolean[][] vst = new boolean[N][N];
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (!vst[j][i]) {
                    bfs(N, map, vst, j, i);
                    
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private static void bfs(int N, String[][] map, boolean[][] vst, int j, int i) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{j, i});
        
        vst[j][i] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            String color = map[now[0]][now[1]];
            
            for (int d = 0; d < 4; d++) {
                int y = now[0] + DY[d];
                
                int x = now[1] + DX[d];
                
                if (0 <= y && y < N && 0 <= x && x < N && !vst[y][x]) {
                    if (!color.equals(map[y][x])) {
                        continue;
                    }
                    
                    vst[y][x] = true;
                    
                    q.offer(new int[]{y, x});
                }
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