
import java.io.*;
import java.util.*;

public class Main {
    private static final int[] DY = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    
    private static final int[] DX = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<int[][]> tests = new ArrayList<>();
        
        while (true) {
            int[] wh = intArr(br);
            
            int w = wh[0];
            
            int h = wh[1];
            
            if (w == 0 && h == 0) {
                break;
            }
            
            int[][] map = new int[h][w];
            
            for (int j = 0; j < h; j++) {
                map[j] = intArr(br); 
            }
            
            tests.add(map);
        }
        
        br.close();
        
        // solution;
        print(solution(tests));
    }
    
    private static int[] solution(List<int[][]> tests) {
        int[] answer = new int[tests.size()];
        
        for (int i = 0; i < tests.size(); i++) {
            int[][] test = tests.get(i);
            
            answer[i] = test(test);
        }
        
        return answer;
    }
    
    private static int test(int[][] test) {
        int answer = 0;
        
        boolean[][] vst = new boolean[test.length][test[0].length];
        
        for (int j = 0; j < test.length; j++) {
            for (int i = 0 ; i < test[0].length; i++) {
                if (test[j][i] == 1 && !vst[j][i]) {
                    dfs(test, j, i, vst);
                    
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private static void dfs(int[][] test, int j, int i, boolean[][] vst) {
        vst[j][i] = true;
        
        for (int d = 0; d < 8; d++) {
            int y = j + DY[d];
            
            int x = i + DX[d];
            
            if (0 <= y && y < test.length && 0 <= x && x < test[0].length && test[y][x] == 1 && !vst[y][x]) {
                dfs(test, y, x, vst);
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