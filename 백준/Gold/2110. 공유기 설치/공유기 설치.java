import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX_DISTANCE = 1_000_000_000;

    static int N, C; // 2 ≤ N(집 개수) ≤ 200,000, 2 ≤ C(공유기 수) ≤ N
    static int[] houses; // 0 ≤ houses[i] ≤ 1,000,000,000

    static int count(int minDistance) {
        int prev = 0, count = 1;
        for (int i = 1; i < N; i++) {
            int distance = houses[i] - houses[prev];
            if (minDistance <= distance) {
                count++;
                prev = i;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int lo = 1, hi = houses[houses.length - 1] - houses[0];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = count(mid);
            if (C <= count) lo = mid + 1; // 거리를 늘려 설치 개수를 줄여야 함
            else hi = mid - 1; // 거리를 좁혀 설치 개수를 늘려야 함
        }

        System.out.println(lo - 1);
    }
}
