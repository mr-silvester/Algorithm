import java.util.*;

class Solution {
    private static int n;
    private static int coin;
    
    public int solution(int coin, int[] cards) {
        n = cards.length;
        this.coin = coin;
        
        int idx = n / 3;
        int answer = 1;
        
        HashSet<Integer> hand = new HashSet<>();
        HashSet<Integer> keep = new HashSet<>();
    
        for (int i = 0; i < n / 3; i++) {
            hand.add(cards[i]);
        }
    
        do {
            int card1 = cards[idx];
            idx++;
            keep.add(card1);

            int card2 = cards[idx];
            idx++;
            keep.add(card2);

            if (pay(hand, keep)) {
                answer++;
                continue;
            }
            return answer;
        } while (idx < n - 1);
        
        return answer;
    }
    
    private boolean pay(HashSet<Integer> hand, HashSet<Integer> keep) {
        if (costZero(hand, keep)) {
            return true;
        }
        if (costOne(hand, keep)) {
            return true;
        }
        if (costTwo(hand, keep)) {
            return true;
        }
        return false;
    }
    
    private boolean costZero(HashSet<Integer> hand, HashSet<Integer> keep) {
        int target = -1;
        int partner = -1;
        
        for (int card : hand) {
            if (hand.contains(n + 1 - card)) {
                target = card;
                partner = n + 1 - target;
                break;
            }
        }
        
        if (target > 0) {
            hand.remove(target);
            hand.remove(partner);
            return true;
        }
        return false;
    }
    
    private boolean costOne(HashSet<Integer> hand, HashSet<Integer> keep) {
        if (coin < 1) {
            return false;
        }
        
        int target = -1;
        int partner = -1;
        
        for (int card : hand) {
            if (keep.contains(n + 1 - card)) {
                target = card;
                partner = n + 1 - target;
                break;
            }
        }
        
        if (target > 0) {
            hand.remove(target);
            keep.remove(partner);
            coin--;
            return true;
        }
        
        return false;
    }
    
    private boolean costTwo(HashSet<Integer> hand, HashSet<Integer> keep) {
        if (coin < 2) {
            return false;
        }
        
        int target = -1;
        int partner = -1;
        
        for (int card : keep) {
            if (keep.contains(n + 1 - card)) {
                target = card;
                partner = n + 1 - target;
                break;
            }
        }
        
        if (target > 0) {
            keep.remove(target);
            keep.remove(partner);
            coin -= 2;
            return true;
        }
        return false;
    }
}