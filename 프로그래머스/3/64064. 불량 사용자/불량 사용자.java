import java.util.*;

class Solution {
    private static final char AST = '*';
    
    public int solution(String[] userIds, String[] bannedIds) {
        int answer = 0;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(userIds.length);
        
        for (int i = 0; i < bannedIds.length; i++) {
            String bannedId = bannedIds[i];
            
            for (int j = 0; j < userIds.length; j++) {
                String userId = userIds[j];
                
                if (matches(userId, bannedId)) {
                    List<Integer> uIds = map.getOrDefault(i, new ArrayList<>());
                    
                    uIds.add(j);
                    
                    map.put(i, uIds);
                }
            }
        }
        
        List<HashSet<Integer>> ids = new ArrayList<>();
        
        Queue<HashSet<Integer>> q = new LinkedList<>();
        
        q.offer(new HashSet<>());
        
        for (List<Integer> uIds : map.values()) {
            int count = q.size();
            
            for (int i = 0; i < count; i++) {
                HashSet<Integer> currentSet = q.poll();
                
                for (int uId : uIds) {
                    HashSet<Integer> extendedSet = new HashSet<>(currentSet);
                    
                    if (extendedSet.add(uId)) {
                        q.offer(extendedSet);
                    }
                }
            }
        }
        
        while (!q.isEmpty()) {
            HashSet<Integer> set = q.poll();
            
            if (set.size() != bannedIds.length) {
                continue;
            }
            
            if (isNew(ids, set)) {
                ids.add(set);
            }
        }
        
        return ids.size();
    }
    
    private boolean isNew(List<HashSet<Integer>> ids, HashSet<Integer> createdIds) {
        for (HashSet<Integer> set : ids) {
            if (set.equals(createdIds)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean matches(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            char c1 = userId.charAt(i);
            
            char c2 = bannedId.charAt(i);
            
            if (c1 == c2 || c2 == AST) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }
}