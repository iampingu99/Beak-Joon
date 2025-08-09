import java.util.*;

class Solution {
    
    public void unmark(int[][] matrix, int[] rectangle){
        int x1 = rectangle[0], y1 = rectangle[1];
        int x2 = rectangle[2], y2 = rectangle[3];
        
        for(int y = y1 + 1; y<y2; y++){
            for(int x = x1 + 1; x<x2; x++){
                matrix[y][x] = 0;
            }
        }
    }
    
    public void mark(int[][] matrix, int[] rectangle){
        int x1 = rectangle[0], y1 = rectangle[1];
        int x2 = rectangle[2], y2 = rectangle[3];
        
        for(int y = y1; y<=y2; y++){
            for(int x = x1; x<=x2; x++){
                matrix[y][x] = 1;
            }
        }
    }
    
    public int bfs(int[][] matrix, int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        deque.offer(new int[]{characterX, characterY, 0});
        visited[characterY][characterX] = true;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        
        while(!deque.isEmpty()){
            int[] node = deque.poll();
            
            if(node[0] == itemX && node[1] == itemY){
                return node[2];
            }
            
            for(int d = 0; d<dx.length; d++){
                int nx = node[0] + dx[d];
                int ny = node[1] + dy[d];
                
                if(nx >= 0 && ny >= 0 && nx < matrix[0].length && ny < matrix.length && !visited[ny][nx] && matrix[ny][nx] == 1){
                    deque.offer(new int[]{nx, ny, node[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] matrix = new int[100 + 1][100 + 1];
        
        for(int[] pos: rectangle){
            mark(matrix, Arrays.stream(pos).map(x -> x * 2).toArray());
        }
        for(int[] pos: rectangle){
            unmark(matrix, Arrays.stream(pos).map(x -> x * 2).toArray());
        }
        
        int answer = bfs(matrix, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
        return answer;
    }
}