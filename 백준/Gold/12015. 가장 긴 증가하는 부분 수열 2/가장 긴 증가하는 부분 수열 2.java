import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1 <= N <= 1,000,000
        int N = intNum(br);
        
        // 1 <= nums[i] <= 1,000,000
        int[] nums = intArr(br);
        
        br.close();
        
        // solution;
        int answer = solution(N, nums);
        
        print(answer);
    }
    
    private static int solution(int N, int[] nums) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        
        for (int num : nums) {
            if (list.isEmpty()) {
                list.add(num);
                
                continue;
            }
            int last = list.get(list.size() - 1);
            
            if (last < num) {
                list.add(num);
                
                continue;
            }
            int idx = binarySearch(list, num);
            
            list.set(idx, num);
        }
        
        return list.size();
    }
    
    private static int binarySearch(ArrayList<Integer> list, int num) {
        int left = 0;
        
        int right = list.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
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