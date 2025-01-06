import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a, b;
        
        a = sc.nextInt();
        
        b = sc.nextInt();
        
        solution(a, b);
    }
    
    public static void solution(int a, int b) {
        String result;
        
        if (a > b) {
            result = ">";
        } else if (a < b) {
            result = "<";
        } else {
            result = "==";
        }
        
        System.out.println(result);
    }
}