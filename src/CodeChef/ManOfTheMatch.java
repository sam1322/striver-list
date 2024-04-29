package CodeChef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManOfTheMatch {
    public static int getSoln() {
        Scanner scanner = new Scanner(System.in);

        int mx = 1;
        int mxVal = 0;
        int cur = 0 ;
        System.out.println("hi");
        for(int i = 0 ; i < 22; i++){
            int len = 2;
//            int[] arr = new int[len];
//            for (int j = 0; j < len; j++) {
//                arr[j] = scanner.nextInt(); // Read the elements of the array
//            }
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(cur + " " + a + " " + b);
            cur = a + b *20;

            if(mxVal < cur){
                mxVal = cur;
                mx = i + 1 ;
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases
        List<Integer> soln = new ArrayList<>();
        for (int i = 0; i < numTestCases; ++i) {

            int ans = getSoln();

            soln.add(ans);
        }

        for (Integer element : soln) {
            System.out.println(element);
        }
    }
}


