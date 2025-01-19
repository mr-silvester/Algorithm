import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = intNum(br);
        
        int[] ports = intArr(br);
        
        br.close();
        
        // solution;
        print(solution(n, ports));
    }
    
    // 1 ≤ n ≤ 40,000
    private static int solution(int n, int[] ports) {
        List<Integer> list = new ArrayList<>(n);
        
        for (int port : ports) {
            if (list.isEmpty()) {
                list.add(port);
            } else {
                int peek = list.get(list.size() - 1);
                
                if (peek < port) {
                    list.add(port);
                } else {
                    int idx = find(list, port);
                    
                    list.set(idx, port);
                }
            }
        }
        
        return list.size();
    }
    
    private static int find(List<Integer> list, int port) {
        int left = 0;
        
        int right = list.size() - 1;
        
        int idx = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int val = list.get(mid);
            
            if (val > port) {
                idx = mid;
                
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return idx;
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