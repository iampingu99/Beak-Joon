import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int N;
    public static int S;
    public static int[] nums;
    public static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=nums.length; i++){
            int sum = 0;
            combination(0, 0, i, sum);
        }
        System.out.println(answer);
    }

    public static void combination(int base, int depth, int k, int sum){
        if(depth == k) {
            if(sum == S) answer++;
            return;
        }
        for(int i = base; i<nums.length; i++){
            combination(i+1, depth+1, k, sum + nums[i]);
        }
    }
}
