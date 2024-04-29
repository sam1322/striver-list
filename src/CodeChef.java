import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CodeChef {
    public static boolean getSoln(int arr[]){
        int n = arr.length;
        for(int i = 0 ; i < n ;++i ){
            if(arr[i] <= 4){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases
        List<String> soln = new ArrayList<>();
        for (int i = 0; i < numTestCases; ++i) {
            int len = scanner.nextInt();

            int[] array = new int[len];
            for (int j = 0; j < len; j++) {
                array[j] = scanner.nextInt(); // Read the elements of the array
            }
            boolean ans = getSoln(array);
            if(ans){
                soln.add("YES");
            }
            else{
                soln.add("NO");
            }
        }

        for (String element : soln) {
            System.out.println(element);
        }
    }
}


