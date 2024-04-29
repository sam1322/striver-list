package CSES;

import java.util.Scanner;

public class MissingNumber {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < n - 1; ++i) {
            int a = scanner.nextInt();
            sum += a;
        }
        long total = ((n * (n + 1)) / 2);
        System.out.println(total - sum);

    }
}
