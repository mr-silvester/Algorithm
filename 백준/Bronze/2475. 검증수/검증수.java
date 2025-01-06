import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numbers = new int[5];
        
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        
        solution(numbers);
    }
    
    public static void solution(int[] numbers) {
        int sum = 0;
        
        for (int number : numbers) {
            sum += number * number;
        }
        
        int result = sum % 10;
        
        System.out.println(result);
    }
}