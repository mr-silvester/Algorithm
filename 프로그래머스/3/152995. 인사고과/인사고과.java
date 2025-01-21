import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] mine = scores[0];
        
        int mySum = mine[0] + mine[1];
        
        ArrayList<int[]> list = new ArrayList<>(scores.length);
        
        for (int i = 1; i < scores.length; i++) {
            int[] score = scores[i];
            
            // 완오 과락
            if (score[0] > mine[0] && score[1] > mine[1]) {
                return -1;
            }
            
            int sum = score[0] + score[1];
            
            if (sum > mySum) {
                answer++;
                
                list.add(new int[]{i, score[0], score[1], sum});
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o1[3], o2[3]);
        });
        
        for (int i = 0; i < list.size() - 1; i++) {
            int[] m = list.get(i);
            
            for (int j = i + 1; j < list.size(); j++) {
                int[] other = list.get(j);
                
                if (other[1] > m[1] && other[2] > m[2]) {
                    answer--;
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}