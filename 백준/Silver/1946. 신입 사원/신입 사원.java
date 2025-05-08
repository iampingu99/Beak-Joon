import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static class Application implements Comparable<Application> {
        int documentRank;
        int interviewRank;

        public Application(int document, int interview) {
            this.documentRank = document;
            this.interviewRank = interview;
        }

        @Override
        public int compareTo(Application o) {
            return Integer.compare(this.documentRank, o.documentRank);
        }
    }

    static int T; // 1 ≤ T(테스트) ≤ 20
    static int N; // 1 ≤ N(지원자) ≤ 100,000
    static List<Application> applications;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            applications = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] param = br.readLine().split(" ");
                int document = Integer.parseInt(param[0]);
                int interview = Integer.parseInt(param[1]);
                applications.add(new Application(document, interview));
            }

            applications = applications.stream()
                    .sorted()
                    .collect(Collectors.toList());

            int answer = 0, limit = Integer.MAX_VALUE;
            for (Application application : applications) {
                if (application.interviewRank < limit) {
                    limit = application.interviewRank;
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
