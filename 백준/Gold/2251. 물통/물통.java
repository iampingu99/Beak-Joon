import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int A, B, C; // 1 ≤ A, B, C ≤ 200

    static class State implements Comparable<State> {
        int[] bottles;

        public State(int[] bottles) {
            this.bottles = bottles;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(bottles);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj.getClass() != getClass()) return false;

            State state = (State) obj;
            return Arrays.equals(bottles, state.bottles);
        }

        @Override
        public int compareTo(State o) {
            return bottles[2] - o.bottles[2];
        }
    }


    static final List<int[]> permutations = new ArrayList<>();
    static final Set<State> states = new HashSet<>();

    static void move(int[][] state, int from, int to) {
        // 옮길 물이 없는 경우
        if (state[from][1] == 0) return;
        // 옮길 곳에 물이 꽉찬 경우
        if (state[to][0] == state[to][1]) return;

        int move = Math.min(state[from][1], state[to][0] - state[to][1]);
        state[from][1] -= move;
        state[to][1] += move;
    }

    static State copy(int[][] state) {
        int[] bottles = new int[3];
        for (int i = 0; i < 3; i++) {
            bottles[i] = state[i][1];
        }
        return new State(bottles);
    }

    static void hello(int[][] state) {
        State s = copy(state);
        if (states.contains(s)) return;
        states.add(s);
        for (int[] permutation : permutations) {
            int originalFrom = state[permutation[0]][1];
            int originalTo = state[permutation[1]][1];
            move(state, permutation[0], permutation[1]);
            hello(state);
            state[permutation[0]][1] = originalFrom;
            state[permutation[1]][1] = originalTo;
        }
    }

    static void permutation(int[] permutation, boolean[] visited, int k) {
        if (k == permutation.length) {
            permutations.add(Arrays.copyOf(permutation, permutation.length));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                permutation[k] = i;
                visited[i] = true;
                permutation(permutation, visited, k + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        A = Integer.parseInt(param[0]);
        B = Integer.parseInt(param[1]);
        C = Integer.parseInt(param[2]);

        permutation(new int[2], new boolean[3], 0);
        hello(new int[][]{{A, 0}, {B, 0}, {C, C}});

        StringBuilder answer = new StringBuilder();
        states.stream()
                .filter(s -> s.bottles[0] == 0)
                .sorted().forEach(v -> answer.append(v.bottles[2]).append(" "));
        System.out.println(answer);
    }
}
