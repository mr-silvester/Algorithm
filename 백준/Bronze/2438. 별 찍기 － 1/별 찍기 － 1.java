import java.util.*;

public class Main {
    private static final String STAR = "*";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        solution(N);
    }
    
    public static void solution(int N) {
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(STAR);
            }
            System.out.println();
        }
    }
}