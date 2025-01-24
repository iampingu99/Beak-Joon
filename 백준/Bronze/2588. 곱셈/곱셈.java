import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int operand1 = Integer.parseInt(br.readLine());
        String operand2 = br.readLine();

        // 1-1. 출력 (3), (4), (5)
        for (int i = operand2.length() - 1; i >= 0; i--) {
            System.out.println(operand1 * (operand2.charAt(i) - '0'));
        }

        // 1-2. 출력(6)
        System.out.println(operand1 * Integer.parseInt(operand2));
    }
}
