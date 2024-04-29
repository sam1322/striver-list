package CodeChef.starters123Div3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomAllocation {
    public static int getSoln(Scanner scanner) {
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int cur = scanner.nextInt();
            double temp = cur / 2.0;
            int k = (int) Math.ceil(temp);
            sum += k;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases
        List<Integer> soln = new ArrayList<>();
        for (int i = 0; i < numTestCases; ++i) {

            int ans = getSoln(scanner);
            soln.add(ans);
        }

        for (Integer element : soln) {
            System.out.println(element);
        }
    }
}
