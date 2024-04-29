package CSES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 4 && n > 1) {
            System.out.println("NO SOLUTION");
        } else {
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                if (i % 2 == 0) {
                    even.add(i);
                } else {
                    odd.add(i);
                }
            }
            for(Integer i : even){
//                System.out.print(i + " ");
                sb.append(i + " ");
            }

            for(Integer i : odd){
                sb.append(i + " ");
//                System.out.print(i + " ");
            }
            System.out.println(sb);
        }
    }
}
