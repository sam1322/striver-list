package CodeChef.starters123Div3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class maximiseAdjacentSum {
    public static long getSoln(Scanner scanner) {
        Long sum = 0L;

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int num = scanner.nextInt();
            list.add(num);
        }

        Collections.sort(list);

        if (list.size() > 0) sum += list.get(0);
        if (list.size() > 1) sum += list.get(1);

        for (int j = 2; j < n; ++j) {
            sum += list.get(j) * 2;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases
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


//SUBMITTED on CODECHEF