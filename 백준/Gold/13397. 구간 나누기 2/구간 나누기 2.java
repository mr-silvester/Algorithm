import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        int[] arr = intArr(br);
        
        br.close();
        
        // solution;
        print(solution(N, M, arr));
    }
    
    private static int solution(int N, int M, int[] arr) {
        int min = 10001;
        
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            
            max = Math.max(max, arr[i]);
        }
        
        int left = 0;
        
        int right = max - min;
        
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (p(arr, M, mid)) {
                answer = mid;
                
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private static boolean p(int[] arr, int M, int mid) {
        int count = 1;
        
        int min = Integer.MAX_VALUE;
        
        int max = - Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            
            max = Math.max(max, arr[i]);
            
            if (max - min > mid) {
                count++;
                
                min = Integer.MAX_VALUE;
            
                max = - min;
                
                i--;
            }
        }
        
        return count <= M;
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