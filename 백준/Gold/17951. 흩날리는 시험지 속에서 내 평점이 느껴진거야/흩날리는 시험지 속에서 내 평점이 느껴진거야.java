
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NK = intArr(br);
        
        int N = NK[0];
        
        int K = NK[1];
        
        int[] arr = intArr(br);
        
        br.close();
        
        // solution;
        print(solution(N, K, arr));
    }
    
    private static int solution(int N, int K, int[] scores) {
        int left = 0;
        
        int right = N * 20;
        
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (possible(N, K, scores, mid)) {
                answer = mid;
                
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private static boolean possible(int N, int K, int[] scores, int min) {
        int groupCount = N;
        
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += scores[i];
            
            if (sum < min) {
                groupCount--;
                
                if (groupCount < K) {
                    return false;
                }
            } else {
                sum = 0;
            }
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