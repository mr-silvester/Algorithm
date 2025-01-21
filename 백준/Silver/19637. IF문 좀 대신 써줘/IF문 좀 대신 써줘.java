
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        String[] names = new String[N];
        
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }
        
        int[] powers = new int[M];
        
        for (int i = 0; i < M; i++) {
            powers[i] = intNum(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, M, names, powers));
    }
    
    private static String[] solution(int N, int M, String[] names, int[] powers) {
        String[] answer = new String[M];
        
        String[] levels = new String[N];
        
        int[][] map = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] s = names[i].split(" ");
            
            levels[i] = s[0];
            
            map[i][0] = i;
            
            map[i][1] = Integer.parseInt(s[1]);
        }
        
        // 오름차순
        Arrays.sort(map, (e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        
        for (int i = 0; i < M; i++) {
            int power = powers[i];
            
            int idx = find(N, M, map, power);
            
            int nameIdx = map[idx][0];
            
            String name = levels[nameIdx];
            
            answer[i] = name;
        }
        
        return answer;
    }
    
    private static int find(int N, int M, int[][] map, int power) {
        int answer = 0;
        
        int left = 0;
        
        int right = N - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int val = map[mid][1];
            
            if (val >= power) {
                answer = mid;
                
                right = mid - 1;
            } else {
                left = mid + 1;
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
}