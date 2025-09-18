import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static class Wheel {
        int[] d;
        int north = 0;
        int rotate = 0;

        public Wheel(int[] d) {
            this.d = d;
        }

        boolean isNorthS() {
            return d[north] == 1;
        }

        int getEast() {
            return d[(north + 2) % 8];
        }

        int getWest() {
            return d[(north + 6) % 8];
        }

        public void setRotate(int rotate) {
            this.rotate = rotate;
        }

        public void rotate() {
            if (rotate == 0) return;
            north = (rotate == 1 ? north + 7 : north + 1) % 8;
            rotate = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int[] d = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            wheels.add(new Wheel(d));
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] param = br.readLine().split(" ");
            int n = Integer.parseInt(param[0]) - 1;
            int r = Integer.parseInt(param[1]);

            wheels.get(n).setRotate(r);

            for (int i = n; i < 3; i++) {
                Wheel curr = wheels.get(i);
                Wheel next = wheels.get(i + 1);
                if (curr.rotate != 0 && curr.getEast() != next.getWest()) {
                    next.setRotate(-curr.rotate);
                } else break;
            }

            for (int i = n; i > 0; i--) {
                Wheel curr = wheels.get(i);
                Wheel next = wheels.get(i - 1);
                if (curr.rotate != 0 && curr.getWest() != next.getEast()) {
                    next.setRotate(-curr.rotate);
                } else break;
            }

            for (Wheel wheel : wheels) {
                wheel.rotate();
            }
        }
        int sum = 0;
        for (int i = 0; i < wheels.size(); i++) {
            if (wheels.get(i).isNorthS()) {
                sum += (int) Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }
}
