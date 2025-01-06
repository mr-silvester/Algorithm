import java.util.*;

public class Main {
    private static final String FORMAT = "%d * %d = %d";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        solution(N);
    }
    
    public static void solution(int N) {
        for (int i = 1; i <= 9; i++) {
            int mul = N * i;
            
            System.out.println(String.format(FORMAT, N, i, mul));
        }
    }
}