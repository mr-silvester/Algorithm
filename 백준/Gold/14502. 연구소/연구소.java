import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        int[][] map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = intArr(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, M, map));
    }
    
    private static int solution(int N, int M, int[][] map) {
        int answer = 0;
        
        List<int[]> spaces = new ArrayList<>();
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (map[j][i] == 0) {
                    spaces.add(new int[]{j, i});
                }
            }
        }
        
        List<List<int[]>> wallComb = new ArrayList<>();
        
        for (int j = 0; j < spaces.size(); j++) {
            for (int i = j + 1; i < spaces.size(); i++) {
                for (int k = i + 1; k < spaces.size(); k++) {
                    List<int[]> walls = new ArrayList<>(3);
                
                    walls.add(spaces.get(j));
                    
                    walls.add(spaces.get(i));
                    
                    walls.add(spaces.get(k));
                    
                    wallComb.add(walls);
                }
            }
        }
        
        for (List<int[]> walls : wallComb) {
            int[][] newMap = apply(N, M, map, walls);
            
            int result = run(N, M, newMap);
            
            answer = Math.max(answer, result);
        }
        
        return answer;
    }
    
    private static int[][] apply(int N, int M, int[][] map, List<int[]> walls) {
        int[][] newMap = new int[N][M];
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                newMap[j][i] = map[j][i];
            }
        }
        
        for (int[] wall : walls) {
            int j = wall[0];
            
            int i = wall[1];
            
            newMap[j][i] = 1;
        }
        
        return newMap;
    }
    
    private static int run(int N, int M, int[][] map) {
        int answer = 0;
        
        boolean[][] vst = new boolean[N][M];
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (map[j][i] == 2 && !vst[j][i]) {
                    dfs(N, M, map, j, i, vst);
                }
            }
        }
        
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (map[j][i] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private static void dfs(int N, int M, int[][] map, int j, int i, boolean[][] vst) {
        map[j][i] = 2;
        
        vst[j][i] = true;
        
        if (j - 1 >= 0 && map[j - 1][i] == 0) {
            dfs(N, M, map, j - 1, i, vst);
        }
        
        if (j + 1 < N && map[j + 1][i] == 0) {
            dfs(N, M, map, j + 1, i, vst);
        }
        
        if (i - 1 >= 0 && map[j][i - 1] == 0) {
            dfs(N, M, map, j, i - 1, vst);
        }
        
        if (i + 1 < M && map[j][i + 1] == 0) {
            dfs(N, M, map, j, i + 1, vst);
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