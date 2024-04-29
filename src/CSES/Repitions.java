package CSES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repitions {
    public static int getSoln(Scanner scanner) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int n = str.length();
        int mx = 0;
        int i = 0;
        int c = 1;

        for (; i < n;) {
             c = 1;
            int j = i + 1;
            for (; j < n; j++, c++) {
                if (str.charAt(i) != str.charAt(j)) {
                    break;
                }
            }
            i = j;
            mx = Math.max(mx, c);

        }
        mx = Math.max(mx, c);
        System.out.println(mx);


    }
}
