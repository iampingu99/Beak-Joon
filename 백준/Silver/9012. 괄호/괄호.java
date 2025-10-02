import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력을 받기 위한 설정
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
		
        // T만큼 반복
        while (T-- > 0) {
            boolean isVPS = true; // 괄호의 짝이 맞는지 판별
            String input = bf.readLine(); // 괄호 입력값 저장
            Stack<Character> stack = new Stack<Character>(); // 스택 생성
            char c; // 입력 문자열을 하나씩 저장할 변수

            // 여는 괄호만 스택에 넣는다.
            for(int i = 0 ; i < input.length() ; i++){
                c = input.charAt(i); // 입력 문자열을 하나씩 저장

                if (c == '('){
                    stack.push(c);
                }

                else if (c == ')'){ // 닫는 괄호인 경우 스택이 비었는지 판별한다.
                    if(!stack.isEmpty()){ // 스택이 비지 않은 경우(스택에 여는 괄호가 있다.)
                        stack.pop(); //  pop
                      } else {  // 스택이 빈 경우(스택에 여는 괄호가 없다.)
                        isVPS = false; // 닫힌 괄호가 나오면 false
                        break;
                    }
                }
            }

            if(!stack.isEmpty()) {isVPS = false;} // 괄호의 짝이 맞지 않았을 경우 false

            if(isVPS) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        } // while 반복문 종료
    }
}