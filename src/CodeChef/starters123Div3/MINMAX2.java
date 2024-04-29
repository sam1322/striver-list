package CodeChef.starters123Div3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MINMAX2 {
    public static Long getSoln(Scanner scanner) {
        Long n = scanner.nextLong();
        Long sum = (n-1)*((n/2) + 1) + 1;

        sum = (n*(n+1))/2 + n - 1;

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long numTestCases = scanner.nextInt(); // Read the number of test cases
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
