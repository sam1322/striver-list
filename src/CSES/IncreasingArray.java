package CSES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncreasingArray {
    public static long getSoln(Scanner scanner) {
        int n = scanner.nextInt();
        int mx = -1;
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            int a = scanner.nextInt();
            if (a < mx) {
                sum += mx - a;
            } else {
                mx = a;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = 1; // Read the number of test cases
        List<Long> soln = new ArrayList<>();
        for (int i = 0; i < numTestCases; ++i) {

            Long ans = getSoln(scanner);
            soln.add(ans);
        }

        for (Long element : soln) {
            System.out.println(element);
        }
    }
}
