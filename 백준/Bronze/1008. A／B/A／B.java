import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int a, b;
        
        a = sc.nextInt();
        
        b = sc.nextInt();
        
        Main main = new Main();
        
        main.solution(a, b);
    }
    
    public void solution(int a, int b) {
        double result = (a * 1.0) / (b * 1.0);
        
        System.out.println(result);
    }
}