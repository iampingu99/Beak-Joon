import java.util.*;

class Solution {
    
    public boolean canConvert(String a, String b){
        int diffCount = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diffCount++;
            if(diffCount >= 2) return false;
        }
        return true;
    }
    
    public int bfs(int beginIdx, int targetIdx, List<Integer>[] adj){
        Queue<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.length];
        deque.offer(new int[]{beginIdx, 0});
        visited[beginIdx] = true;
        
        while(!deque.isEmpty()){
            int[] node = deque.poll();
            if(node[0] == targetIdx){
                return node[1];
            }
            for(int v: adj[node[0]]){
                if(!visited[v]){
                    deque.offer(new int[]{v, node[1] + 1});
                    visited[v] = true;
                }
            }
        }
        
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        List<Integer>[] maps = new ArrayList[words.length + 1];
        for(int i = 0; i<maps.length; i++){
            maps[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<words.length; i++){
            for(int j = i + 1; j<words.length; j++){
                if(canConvert(words[i], words[j])) {
                    maps[i].add(j);
                    maps[j].add(i);
                }
            }
        }
        
        int targetIdx = -1;
        for(int i = 0; i<words.length; i++){
            if(target.equals(words[i])) targetIdx = i;
            if(canConvert(begin, words[i])) {
                maps[maps.length - 1].add(i);
                maps[i].add(maps.length - 1);
            }
        }
        
        int answer = targetIdx == -1 ? 0 : bfs(maps.length -1, targetIdx, maps);
        
        return answer;
    }
}