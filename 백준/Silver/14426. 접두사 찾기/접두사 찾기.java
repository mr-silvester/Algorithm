import java.io.*;
import java.util.*;

public class Main {
    private static final String TRUE = "1";
    
    private static final String FALSE = "0";
    
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = intArr(br);
        
        int N = NM[0];
        
        int M = NM[1];
        
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        String[] prefixes = new String[M];
        
        for (int i = 0; i < M; i++) {
            prefixes[i] = br.readLine();
        }
        
        br.close();
        
        // solution;
        print(solution(N, M, words, prefixes));
    }
    
    private static int solution(int N, int M, String[] words, String[] prefixes) {
        int answer = 0;
      
        List<String[]> dic = new ArrayList<>(N + M);
        
        for (String word : words) {
            dic.add(new String[]{word, TRUE});
        }
        
        for (String prefix : prefixes) {
            dic.add(new String[]{prefix, FALSE});
        }
        
        Collections.sort(dic, (w1, w2) -> {
            return w2[0].compareTo(w1[0]);
        });
        
        String target = null;
        
        for (int i = 0; i < dic.size(); i++) {
            String[] word = dic.get(i);
            
            if (word[1].equals(TRUE)) {
                target = word[0];
                
                continue;
            }
            
            if (target == null) {
                continue;
            }
            
            if (target.startsWith(word[0])) {
                answer++;
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
    
    private static void println(long[] arr) {
        for (long n : arr) {
            System.out.println(n);
        }
    }
    
    private static void print(String[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        
        for (String s : arr) {
            sb.append(s).append(" ");
        }
        
        System.out.print(sb.toString());
    }
    
    
    private static String[] strArr(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
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
    
    private static long longNum(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }
    
    private static long[] longArr(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        
        long[] result = new long[input.length];
        
        for (int i = 0; i < input.length; i++) {
            result[i] = Long.parseLong(input[i]);
        }
        
        return result;
    }
}