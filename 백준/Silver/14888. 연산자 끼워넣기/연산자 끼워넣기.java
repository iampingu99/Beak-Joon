import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static int N;
    public static int[] nums;
    public static int[] operator;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operator = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arr = new int[N-1];
        permutation(0, arr);
        System.out.println(max);
        System.out.println(min);
    }

    public static void permutation(int depth, int[] arr){
        if(depth == N-1){
            int result = nums[0];
            for(int i = 1, j = 0; i<nums.length; i++){
                switch (arr[j++]){
                    case 0 : {
                        result += nums[i];
                        break;
                    }
                    case 1 : {
                        result -= nums[i];
                        break;
                    }
                    case 2 : {
                        result *= nums[i];
                        break;
                    }
                    case 3 : {
                        result /= nums[i];
                        break;
                    }
                };
            }
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for(int i = 0; i<operator.length; i++){
            if(operator[i] == 0) continue;
            operator[i] -= 1;
            arr[depth] = i;
            permutation(depth + 1, arr);
            operator[i] += 1;
        }
    }
}
