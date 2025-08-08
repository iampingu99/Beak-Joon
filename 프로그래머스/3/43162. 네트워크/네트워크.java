class Solution {
    class UnionFind{
        private int[] id;
        private int count;
        
        public UnionFind(int n){
            count = n;
            id = new int[n];
            for(int i = 0; i<n; i++){
                id[i] = i;
            }
        }
        
        public int find(int p){
            while(id[p] != p){
                p = id[p];
            }
            return p;
        }
        
        public void union(int p, int q){
            int pid = find(p);
            int qid = find(q);
            if(pid == qid) return;
            id[qid] = pid;
            count--;
        }
        
        public int count(){
            return count;
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        UnionFind uf = new UnionFind(n + 1);
        for(int i = 0; i<computers.length; i++){
            for(int j = 0; j<computers[i].length; j++){
                if(computers[i][j] == 1) uf.union(i + 1, j + 1);
            }
        }
        
        int answer = uf.count() - 1;
        return answer;
    }
}