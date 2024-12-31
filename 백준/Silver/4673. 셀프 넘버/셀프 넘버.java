public class Main {
    static final int MAX_NUM = 10_000 + 1;
    static boolean[] hasGenerator;

    static void dfs(int n) {
        String s = String.valueOf(n);
        int sum = n;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            if (sum >= MAX_NUM) {
                return;
            }
        }
        hasGenerator[sum] = true;
        dfs(sum);
    }

    public static void main(String[] args) {
        // 0. 입력 및 초기화
        StringBuilder answer = new StringBuilder();
        hasGenerator = new boolean[MAX_NUM];

        // 1. 생성자 검사 배열 채우기
        for (int i = 1; i < MAX_NUM; i++) {
            if (!hasGenerator[i]) {
                dfs(i);
            }
        }

        // 2. 출력
        for (int i = 1; i < hasGenerator.length; i++) {
            if (!hasGenerator[i]) {
                answer.append(i).append("\n");
            }
        }
        System.out.println(answer);
    }
}
