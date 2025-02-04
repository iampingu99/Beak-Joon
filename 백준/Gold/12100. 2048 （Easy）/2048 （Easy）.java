import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N ≤ 20
    static int[][] board;
    static int[][] copy;
    static int answer;

    static void duplicatePermutation(int[] arr, int k) {
        if (k == 5) {
            copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                copy[i] = Arrays.copyOf(board[i], N);
            }
            for (int d : arr) {
                if (d == 0) left(copy);
                else if (d == 1) right(copy);
                else if (d == 2) down(copy);
                else up(copy);
            }
            findMax(copy);
            return;
        }
        for (int d = 0; d < 4; d++) {
            arr[k] = d;
            duplicatePermutation(arr, k + 1);
        }
    }

    static void findMax(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
    }

    // 열 우선 / 행: 순방향 / 열: 순방향 / 위치: 순방향
    static void left(int[][] board) {
        int pos, last, num;
        for (int i = 0; i < N; i++) {
            pos = 0;
            last = 0;
            for (int j = 0; j < N; j++) {
                num = board[i][j];
                if (num == 0) continue;

                board[i][j] = 0;
                if (num == last) {
                    board[i][pos - 1] = num + last;
                    last = 0;
                } else {
                    board[i][pos++] = num;
                    last = num;
                }
            }
        }
    }

    // 열 우선 / 행: 순방향 / 열: 역방향 / 위치: 역방향
    static void right(int[][] board) {
        int pos, last, num;
        for (int i = 0; i < N; i++) {
            pos = N - 1;
            last = 0;
            for (int j = N - 1; j >= 0; j--) {
                num = board[i][j];
                if (num == 0) continue;

                board[i][j] = 0;
                if (num == last) {
                    board[i][pos + 1] += num;
                    last = 0;
                } else {
                    board[i][pos--] = num;
                    last = num;
                }
            }
        }
    }

    // 행 우선 / 행: 순방향 / 열: 순방향 / 위치: 순방향
    static void up(int[][] board) {
        int pos, last, num;
        for (int i = 0; i < N; i++) {
            pos = 0;
            last = 0;
            for (int j = 0; j < N; j++) {
                num = board[j][i];
                if (num == 0) continue;

                board[j][i] = 0;
                if (num == last) {
                    board[pos - 1][i] = num + last;
                    last = 0;
                } else {
                    board[pos++][i] = num;
                    last = num;
                }
            }
        }
    }

    // 행 우선 / 행: 역방향 / 열: 순방향 / 위치: 역방향
    static void down(int[][] board) {
        int pos, last, num;
        for (int i = 0; i < N; i++) {
            pos = N - 1;
            last = 0;
            for (int j = N - 1; j >= 0; j--) {
                num = board[j][i];
                if (num == 0) continue;

                board[j][i] = 0;
                if (num == last) {
                    board[pos + 1][i] = num + last;
                    last = 0;
                } else {
                    board[pos--][i] = num;
                    last = num;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 0-1. 보드 정보 입력
        board = new int[N][];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 1. 상/하/좌/우 5개 선택: 중복 순열
        // 2. 보드 값을 2048 규칙으로 갱신
        duplicatePermutation(new int[5], 0);

        // 3. 보드의 최대 값 출력
        System.out.println(answer);
    }

//    static int[] getMergeLine(int[] line) {
//        int[] mergeLine = new int[N];
//        int pos = 0;
//        int last = 0;
//        for (int num : line) {
//            if (num == 0) continue;
//            if (num == last) {
//                mergeLine[pos - 1] = num + last;
//                last = 0;
//            } else {
//                mergeLine[pos++] = num;
//                last = num;
//            }
//        }
//        return mergeLine;
//    }
}
