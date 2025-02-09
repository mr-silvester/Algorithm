import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = intNum(br);
        
        int[][] infoN = new int[N][];
        
        for (int i = 0; i < N; i++) {
            infoN[i] = intArr(br);
        }
        
        int M = intNum(br);
        
        int[][] infoM = new int[M][];
        
        for (int i = 0; i < M; i++) {
            infoM[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, infoN, M, infoM));
    }
    
    private static int solution(int N, int[][] infoN, int M, int[][] infoM) {
        int max = Integer.MAX_VALUE;
        
        int answer = max;
        
        int[] dy = new int[]{1, 0, -1, 0};
        
        int[] dx = new int[]{0, 1, 0, -1};
        
        int[][] map = new int[501][501];
        
        for (int[] info : infoN) {
            fill(map, info, 1);
        }
        
        for (int[] info : infoM) {
            fill(map, info, 2);
        }
        
        int[][] costs = new int[501][501];
        
        for (int j = 0; j < 501; j++) {
            for (int i = 0; i < 501; i++) {
                costs[j][i] = max;
            }
        }
        
        costs[0][0] = 0;
        
        boolean[][] vst = new boolean[501][501];
        
        // y, x, cost
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1[2], n2[2]);
        });
        
        q.add(new int[]{0, 0, 0});
        
        map[0][0] = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (vst[now[0]][now[1]]) {
                continue;
            }
            
            vst[now[0]][now[1]] = true;
            
            for (int d = 0; d < 4; d++) {
                int y = now[0] + dy[d];
                
                int x = now[1] + dx[d];
                
                if (0 <= y && y < 501 && 0 <= x && x < 501) {
                    int lv = map[y][x];
                    
                    if (lv == 2) {
                        continue;
                    }
                    
                    int originalCost = costs[y][x];
                    
                    int newCost = now[2] + lv;
                    
                    if (originalCost > newCost) {
                        q.add(new int[]{y, x, newCost});
                        
                        costs[y][x] = newCost;
                    }
                }
            }
        }
        
        if (costs[500][500] == max) {
            return -1;
        }
        
        return costs[500][500];
    }
    
    private static void fill(int[][] map, int[] info, int lv) {
        int y1 = Math.min(info[0], info[2]);
        
        int y2 = Math.max(info[0], info[2]);
        
        int x1 = Math.min(info[1], info[3]);
        
        int x2 = Math.max(info[1], info[3]);
        
        for (int j = y1; j <= y2; j++) {
            for (int i = x1; i <= x2; i++) {
                map[j][i] = Math.max(map[j][i], lv);
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