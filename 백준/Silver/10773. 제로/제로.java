import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        while(K-->0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) answer -= stack.pop();
            else answer += stack.push(num);
        }
        System.out.println(answer);
    }
}
