import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] pieces = new int[6];
        
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = sc.nextInt();
        }
        
        int[] count = new int[]{1, 1, 2, 2, 2 ,8};
        
        solution(count, pieces);
    }

    public static void solution(int[] count, int[] pieces) {
        for (int i = 0; i < count.length; i++) {
            int diff = count[i] - pieces[i];
            
            System.out.print(diff + " ");
        }
    }
}