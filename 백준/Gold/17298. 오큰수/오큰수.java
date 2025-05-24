import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<N; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                answer[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer).forEach(v -> sb.append(v).append(" "));
        System.out.println(sb);
    }
}
