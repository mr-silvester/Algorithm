import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2 <= N <= 100,000
        int N = intNum(br);
        
        // -1,000,000,000 <= e <= 1,000,000,000
        // asc
        int[] sols = intArr(br);
        
        br.close();
        
        // solution;
        int[] answer = solution(N, sols);
        
        print(answer);
    }
    
    private static int[] solution(int N, int[] sols) {
        int[] answer = new int[2];
        
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        
        int right = N - 1;
        
        while (left < right) {
            int sum = sols[left] + sols[right];
            
            if (sum == 0) {
                answer[0] = sols[left];
                
                answer[1] = sols[right];
                
                break;
            }
            
            int diff = Math.abs(sum);
            
            if (min > diff) {
                min = diff;
                
                answer[0] = sols[left];
                
                answer[1] = sols[right];
            }
            
            if (sum > 0) {
                right--;
            }
            if (sum < 0) {
                left++;
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