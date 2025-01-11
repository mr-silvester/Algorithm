import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String, Enroll> graph = new HashMap<>(enroll.length);
        
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            
            Enroll en = new Enroll(name, graph.get(referral[i]));
            
            graph.put(name, en);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            
            int money = amount[i] * 100;
            
            graph.get(name).earn(money);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = graph.get(enroll[i]).earn;
        }
        
        return answer;
    }
}

class Enroll {
    String name;
    
    Enroll ref;
    
    int earn;
    
    Enroll(String name, Enroll ref) {
        this.name = name;
        
        this.ref = ref;
        
        this.earn = 0;
    }
    
    void earn(int money) {
        int tax = money / 10;
        
        earn += money - tax;
        
        if (ref != null) {
            ref.earn(tax);
        }
    }
}