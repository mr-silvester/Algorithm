import java.util.*;
import java.io.*;

public class Main {
    private static final double CRITERIA = 0.9;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] files = new int[N];
        
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(input[i]);
        }
        
        br.close();
        
        long answer = solution(N, files);
        
        System.out.print(answer);
    }
    
    public static long solution(int N, int[] files) {
        long answer = 0;

        if (N == 1) {
            return 0;
        }

        Arrays.sort(files);

        for (int i = 0; i < files.length; i++) {
            int x = binarySearch(files, i);
            
            if (x >= 0) {
                answer += x - i;
            }
        }
        
        return answer;
    }
    
    private static int binarySearch(int[] arr, int x) {
        int left = x + 1;
        
        int right = arr.length - 1;
        
        int value = arr[x];
        
        int result = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (value * 10 >= arr[mid] * 9) {
                result = mid;
                
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}