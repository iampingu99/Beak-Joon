class Solution {
    
    int total, answer;
            
    // combination
    public void combination(int[] numbers, int[] result, int base, int depth, int k, int target){
        if(depth == k) {
            int sum = 0;
            for(int i = 0; i<result.length; i++){
                sum += result[i];
            }
            if(Math.max((total - sum), sum) - Math.min((total - sum), sum) == target) answer++;
            return;
        }
        
        for(int i = base; i<numbers.length; i++){
            result[depth] = numbers[i];
            combination(numbers, result, i + 1, depth + 1, k, target);
        }
    }
    
    public int solution(int[] numbers, int target) {
        
        for(int i = 0; i<numbers.length; i++){
            total += numbers[i];
        }
        
        for(int k = 1; k<numbers.length; k++){
            combination(numbers, new int[k], 0, 0, k, target);
        }
        
        return answer/2;
    }
}