package CodeChef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TransformationCost {
    public static int getSoln(Scanner scanner) {

        int a = scanner.nextInt();
        int b = a;
        int k = 0;
        while (a > 1) {
            a /= 2;
            k++;
        }
        int c = 1;
        for (int i = 0; i < k; ++i)
            c = c << 1;
        int d = c ;
        while(c < b){
            d = d>>1;
            c = c+d;
        }
        return Math.abs(c-b);
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
