import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 *     <li>각 K가 세 삼각수의 합으로 나타낼 수 있는 지 확인 O(T * 44^3)</li>
 *     <li>세 삼각수의 합으로 나타낼 수 있는 모든 수를 미리 계산 O(T + 44^3)/li>
 * </ul>
 */
public class Main {
    static int T;
    static int K; //3 ≤ K ≤ 1,000
    static int MAX = 1_000;

    static List<Integer> getTriangleNums(int maxValue) {
        List<Integer> triangleNums = new ArrayList<>();
        for (int i = 1; ; i++) {
            int triangleNum = i * (i + 1) / 2;
            if (triangleNum > maxValue) {
                break;
            }
            triangleNums.add(triangleNum);
        }
        return triangleNums;
    }

    static boolean[] getEurekaNums(List<Integer> triangleNums) {
        boolean[] eurekaNums = new boolean[MAX + 1];
        for (int i = 0; i < triangleNums.size(); i++) {
            for (int j = 0; j < triangleNums.size(); j++) {
                for (int k = 0; k < triangleNums.size(); k++) {
                    int eurekaNum = triangleNums.get(i) + triangleNums.get(j) + triangleNums.get(k);
                    if (eurekaNum <= MAX) {
                        eurekaNums[eurekaNum] = true;
                    }
                }
            }
        }
        return eurekaNums;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //1. 경계까지의 모든 삼각수 구하기 O(44)
        List<Integer> triangleNums = getTriangleNums(MAX);

        //2. 모든 유레카 수(정확히 세 삼각수의 합으로 나타낼 수 있는 수)구하기 O(44^3)
        boolean[] eurekaNums = getEurekaNums(triangleNums);

        //3. 해당 수가 유레카 수 인지 확인 O(T)
        int answer;
        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());
            answer = eurekaNums[K] ? 1 : 0;
            System.out.println(answer);
        }
    }
}
