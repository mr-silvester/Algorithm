import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NH = intArr(br);
        
        int N = NH[0];
        
        int H = NH[1];
        
        int[] obstacles = new int[N];
        
        for (int i = 0; i < N; i++) {
            obstacles[i] = intNum(br);
        }
        
        br.close();
        
        // solution;
        print(solution(N, H, obstacles));
    }
    
    // 2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000
    private static int[] solution(int N, int H, int[] obstacles) {
        int[] answer = new int[2];
        
        List<Integer> ups = new ArrayList<>(N / 2);

        List<Integer> downs = new ArrayList<>(N / 2);

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                ups.add(obstacles[i]);
            } else {
                downs.add(obstacles[i]);
            }
        }

        Collections.sort(ups);

        Collections.sort(downs);

        answer[0] = N;

        for (int i = 1; i <= H; i++) {
            int conf = run(ups, i) + run(downs, H + 1 - i);
            
            if (conf < answer[0]) {
                answer[0] = conf;
                
                answer[1] = 1;
                
                continue;
            }
            if (conf == answer[0]) {
                answer[1]++;
            }
        }
        
        return answer;
    }

    private static final int run(List<Integer> obs, int h) {
        int left = 0;
        
        int right = obs.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int o = obs.get(mid);
            
            if (o >= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return obs.size() - left;
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