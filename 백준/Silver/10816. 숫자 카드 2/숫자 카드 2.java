import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br
                    = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr1 = intArr(br, N);
        
        int M = Integer.parseInt(br.readLine());
        
        int[] arr2 = intArr(br, M);
        
        solution(N, arr1, M, arr2);
        
        br.close();
    }
    
    public static void solution(int N, int[] arr1, int M, int[] arr2) {
        int[] plus = new int[10000001];
        
        int[] minus = new int[10000001];
        
        for (int n : arr1) {
            if (n >= 0) {
                plus[n]++;
            } else {
                minus[-n]++;
            }
        }
        
        for (int m : arr2) {
            if (m >= 0) {
                System.out.print(plus[m] + " ");
            } else {
                System.out.print(minus[-m] + " ");
            }
        }
    }
    
    public static int[] intArr(BufferedReader br, int length) throws IOException {
        String blank = " ";
        
        String[] input = br.readLine().split(blank);
        
        int[] arr = new int[length];
        
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        return arr;
    }
}