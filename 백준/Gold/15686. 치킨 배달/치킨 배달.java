import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int MARK_CHICKEN = 2;
    static final int MARK_HOUSE = 1;
    static final List<Coordinate> chickens = new ArrayList<>();
    static final List<Coordinate> houses = new ArrayList<>();

    static int N; // 2 ≤ N ≤ 50
    static int M; // 1 ≤ M ≤ 13
    static int answer = Integer.MAX_VALUE;

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // array combination: back-tracking
    static void selectedChicken(int[] selectedIdx, int base, int k) {
        if (k == M) {
            calcChickenDistance(selectedIdx);
            return;
        }

        for (int i = base; i < chickens.size(); i++) {
            selectedIdx[k] = i;
            selectedChicken(selectedIdx, i + 1, k + 1);
        }
    }

    static void calcChickenDistance(int[] selectedIdx) {
        // 도시 치킨 거리 계산
        int cityChickDistance = 0;
        for (Coordinate house : houses) {
            // 집 치킨 거리 계산
            int houseChickDistance = Integer.MAX_VALUE;
            for (int idx : selectedIdx) {
                Coordinate chicken = chickens.get(idx);
                houseChickDistance = Math.min(houseChickDistance,
                        Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
            }
            cityChickDistance += houseChickDistance;
        }
        answer = Math.min(answer, cityChickDistance);
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 치킨 좌표 저장
        // 0-2. 집 좌표 저장
        for (int i = 0; i < N; i++) {
            param = br.readLine().split(" ");
            for (int j = 0; j < param.length; j++) {
                int mark = Integer.parseInt(param[j]);
                if (mark == MARK_CHICKEN) chickens.add(new Coordinate(i, j));
                else if (mark == MARK_HOUSE) houses.add(new Coordinate(i, j));
            }
        }

        // 1. 폐업 시키지 않을 치킨 집 선택: 조합
        // 2. 집 치킨 거리 계산
        // 3. 도시 치킨 거리 계산
        selectedChicken(new int[M], 0, 0);

        // 4. 출력
        System.out.println(answer);
    }
}
