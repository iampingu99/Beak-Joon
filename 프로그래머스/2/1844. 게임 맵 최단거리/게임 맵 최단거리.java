import java.util.*;

class Solution {

    public int bfs(int x, int y, int[][] maps){
        Queue<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        deque.offer(new int[]{x, y, 1});
        visited[y][x] = true;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        while(!deque.isEmpty()){
            int[] pos = deque.poll();
            if(pos[0] == maps[0].length - 1 && pos[1] == maps.length - 1){
                return pos[2];
            }
            
            for(int d = 0; d<dx.length; d++){
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];
                if(nx >=0 && ny >= 0 && nx < maps[0].length && ny < maps.length && !visited[ny][nx] && maps[ny][nx] == 1){
                    deque.offer(new int[]{nx, ny, pos[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        return -1;
        
    }
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);
        return answer;
    }
}