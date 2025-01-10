class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        
        int[][] map = new int[board.length + 1][board[0].length + 1];
        
        for (int[] skill : skills) {
            apply(map, skill);
        }
        
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 1; j < map.length; j++) {
                map[j][i] += map[j - 1][i];
            }
        }
        
        for (int j = 0; j < map.length; j++) {
            for (int i = 1; i < map[0].length; i++) {
                map[j][i] += map[j][i - 1];
            }
        }
        
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                board[j][i] += map[j][i];
                
                if (board[j][i] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    void apply(int[][] map, int[] skill) {
        int sign = skill[0] == 1 ? -1 : 1;
        
        int degree = skill[5] * sign;
        
        int y1 = skill[1];
        
        int y2 = skill[3];
        
        int x1 = skill[2];
        
        int x2 = skill[4];
        
        map[y1][x1] += degree;
        
        map[y1][x2 + 1] += - degree;
        
        map[y2 + 1][x1] += - degree;
        
        map[y2 + 1][x2 + 1] += degree;
    }
}