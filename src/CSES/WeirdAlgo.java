package CSES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeirdAlgo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        while (n != 1) {
            list.add(n);
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
        }
        for (long num : list) {
            System.out.printf("%s ", num);
        }
        System.out.println(1);

    }
}
