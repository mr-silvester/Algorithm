import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1 <= N <= 500,000
        int N = Integer.parseInt(br.readLine());
        
        int[] myCards = intArr(br);
        
        // 1 <= M <= 500,000
        int M = Integer.parseInt(br.readLine());
        
        int[] cards = intArr(br);
        
        br.close();
        
        // solution;
        int[] answer = solution(N, myCards, M, cards);
        
        print(answer);
    }
    
    private static int[] solution(int N, int[] myCards, int M, int[] cards) {
        int[] answer = new int[M];
        
        Arrays.sort(myCards);
        
        for (int i = 0; i < M; i++) {
            int idx = Arrays.binarySearch(myCards, cards[i]);
            
            if (idx >= 0) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        
        for (int n : arr) {
            sb.append(n).append(" ");
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