import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<operations.length; i++){
            String[] param = operations[i].split(" ");
            String op = param[0];
            int num = Integer.parseInt(param[1]);
        
            if(op.equals("I")) {
                minQueue.offer(num);
                maxQueue.offer(num);
            }
            else {
                if(minQueue.isEmpty()) continue;
                if(num == 1) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
                else {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }
        
        int[] answer = minQueue.isEmpty() ? new int[]{0, 0} : new int[]{maxQueue.poll(), minQueue.poll()};
        return answer;
    }
}