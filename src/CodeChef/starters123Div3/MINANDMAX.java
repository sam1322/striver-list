package CodeChef.starters123Div3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MINANDMAX {
    public static Long getSoln(Scanner scanner) {
        Long n = scanner.nextLong();
//        Long sum = 0L;
//
//        if(n%2==0){
//            sum = (n*(n+2))/4;
//        }
//        else{
//            sum = ((n+2)*(n+2) -1 )/4;
//        }

        Long k = n / 2;
        // The initial formula for when N is even: k * (k + 1)
        Long sum = k * (k + 1);
        // If N is odd, we need to add (k + 1) again to the sum
        if (n % 2 == 1) {
            sum += (k + 1);
        }
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
