import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static class Score {
        int document;
        int interview;

        public Score(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        public int getDocument() {
            return document;
        }

        public int getInterview() {
            return interview;
        }
    }

    static int T; // 1 ≤ T(테스트) ≤ 20
    static int N; // 1 ≤ N(지원자) ≤ 100,000
    static List<Score> scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            scores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] param = br.readLine().split(" ");
                int document = Integer.parseInt(param[0]);
                int interview = Integer.parseInt(param[1]);
                scores.add(new Score(document, interview));
            }

            scores = scores.stream()
                    .sorted(Comparator.comparing(Score::getDocument))
                    .collect(Collectors.toList());

            int answer = 0, limit = Integer.MAX_VALUE;
            for (int i = 0; i < scores.size(); i++) {
                int target = scores.get(i).getInterview();
                if (target > limit) continue;
                limit = target;
                answer++;
            }

            System.out.println(answer);
        }
    }
}
