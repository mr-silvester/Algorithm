import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2 <= N <= 100,0000
        int N = intNum(br);
        
        // -1,000,000,000 <= e <= 1,000,000,000
        int[] solutions = intArr(br);
        
        br.close();
        
        // solution;
        print(solution(N, solutions));
    }
    
    private static int[] solution(int N, int[] solutions) {
        // -99 -2 -1 4 98
        Arrays.sort(solutions);
        
        int min = Integer.MAX_VALUE;
        
        int[] answer = new int[]{-1, -1};
        
        int left = 0;
        
        int right = N - 1;
        
        while (left < right) {
            int sum = solutions[left] + solutions[right];
            
            if (sum == 0) {
                return new int[]{solutions[left], solutions[right]};
            }
            
            int diff = Math.abs(sum);
            
            if (min > diff) {
                min = diff;
                
                answer[0] = solutions[left];
                
                answer[1] = solutions[right];
            }
            
            if (sum > 0) {
                right--;
            } else {
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