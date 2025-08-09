import java.util.*;

class Solution {
    
    class Node{
        private String str;
        private int dist;
        
        public Node(String str, int dist){
            this.str = str;
            this.dist = dist;
        }
        
        public String getStr(){
            return str;
        }
        
        public int getDist(){
            return dist;
        }
    }
    
    public boolean canConvert(String a, String b){
        int diff = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff >= 2) return false;
        }
        return true;
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<Node> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        deque.offer(new Node(begin, 0));
        
        while(!deque.isEmpty()){
            Node node = deque.poll();
            
            if(node.getStr().equals(target)){
                return node.getDist();
            }
            
            for(int i = 0; i<words.length; i++){
                if(canConvert(node.getStr(), words[i]) && !visited[i]){
                    deque.offer(new Node(words[i], node.getDist() + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        return answer;
    }
}