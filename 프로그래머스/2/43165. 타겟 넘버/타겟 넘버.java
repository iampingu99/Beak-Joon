class Solution {    
    private int dfs(int[] numbers, int sum, int k, int target){
        if(k == numbers.length){
            if(sum == target) return 1;
            return 0;
        }
        
        return dfs(numbers, sum + numbers[k], k + 1, target) + dfs(numbers, sum - numbers[k], k + 1, target);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }
}