import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] arr1 = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        
        int M = sc.nextInt();
        
        int[] arr2 = new int[M];
        
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        
        solution(N, arr1, M, arr2);
    }
    
    public static void solution(int N, int[] arr1, int M, int[] arr2) {
        HashSet<Integer> set = new HashSet<>(N);
        
        for (int n : arr1) {
            set.add(n);
        }
        
        for (int m : arr2) {
            int value = set.contains(m) ? 1 : 0;
            
            System.out.println(value);
        }
    }
}