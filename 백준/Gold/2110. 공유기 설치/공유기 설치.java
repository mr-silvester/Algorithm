import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] line1 = intArr(br);
        
        // 2 <= N <= 200,000
        int N = line1[0];
        
        // 2 <= C <= N
        int C = line1[1];
        
        // 0 <= x <= 1,000,000,000
        int[] home = new int[N];
        
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
        
        // solution;
        int answer = solution(N, C, home);
        
        System.out.print(answer);
    }
    
    private static int solution(int N, int C, int[] home) {
        int answer = 0;
        
        Arrays.sort(home);
        
        int left = 1;
        
        int right = home[N - 1] - home[0];
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (valid(N, C, home, mid)) {
                answer = mid;
                
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private static boolean valid(int N, int C, int[] home, int d) {
        int count = 1; 
        
        int lastPosition = home[0];

        for (int i = 1; i < N; i++) {
            if (home[i] - lastPosition >= d) {
                count++;
                lastPosition = home[i];
            }
        }

        return count >= C;
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
    
    private static int[] intArr(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        
        int[] result = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        
        return result;
    }
}