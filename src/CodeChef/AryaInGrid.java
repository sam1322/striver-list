package CodeChef;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AryaInGrid {
    public static BigInteger getSoln(Scanner scanner) {
        BigInteger mx = BigInteger.valueOf(1);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long l = scanner.nextLong();
        if(l==1){
            mx = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));
            return mx;
        }

//        long a = (n- 1)/l;
//        long b = (m - 1)/l;
//        x--;
//        y--;
//
//        long left = (x - 1) / l;
//        long right = (m - x) / l;
//        long up = (y - 1) / l;
//        long down = (n - y) / l;
//        long calc = (up + down) * (left + right);
////        System.out.println(left + ", " + right + ", " + up + ", " + down) ;
////        System.out.println("calc  : " + calc);
//        mx = BigInteger.valueOf(calc + left + right + up + down + 1);
//        System.out.println("mx : "+mx.longValue());

        long dx = (x - 1) / l + (n - x) / l + 1;
        long dy = (y - 1) / l + (m - y) / l + 1;

        // The total number of distinct cells Arya can reach is the product of dx and dy
        return BigInteger.valueOf(dx).multiply(BigInteger.valueOf(dy));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases
        List<BigInteger> soln = new ArrayList<>();
        for (int i = 0; i < numTestCases; ++i) {

            BigInteger ans = getSoln(scanner);

            soln.add(ans);
        }

        for (BigInteger element : soln) {
            System.out.println(element);
        }
    }
}
