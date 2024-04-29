//package CSES;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberSpiral {
    public static Long getSoln(Scanner scanner) {
        Long x = scanner.nextLong();
        Long y = scanner.nextLong();

        Long mx = Math.max(x, y);

        Long diff = x < y ? x : y;
        Boolean t = x < y ? y % 2 == 1 : (x % 2 == 0);

//        BigInteger ans;
//        BigInteger mx2 = BigInteger.valueOf(mx * mx);
//        BigInteger mn2 = BigInteger.valueOf((mx - 1) * (mx - 1));
        Long ans;
        Long mx2 = mx * mx;
        Long mn2 = (mx - 1) * (mx - 1);

        if (t) {
            ans = mx2 - (diff - 1);
//            ans = mx2.subtract(BigInteger.valueOf(diff - 1));
        } else {
            ans = mn2 + (diff);
//            ans = mn2.add(BigInteger.valueOf(diff));
        }
        return ans;
//        return ans.longValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numTestCases = scanner.nextInt(); // Read the number of test cases
        for (int i = 0; i < numTestCases; ++i) {

            Long ans = getSoln(scanner);
            sb.append(ans + "\n");
        }

        System.out.println(sb);

    }
}
