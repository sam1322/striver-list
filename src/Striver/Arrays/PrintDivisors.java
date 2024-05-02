package Striver.Arrays;

import java.util.*;

public class PrintDivisors {
    public static List<Integer> printDivisors(Scanner scanner , int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i * i  <= n ; ++i ){
            if(n%i==0){
                list.add(i);
                if(n/i !=i) list.add(n/i);
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void Hashing(Scanner sc){
        int n ;
        System.out.println("Enter a number : ");
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; ++i){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < n  ; ++i ){
            int key = arr[i];
            int freq = 0 ;
            if(mp.containsKey(key)) freq = mp.get(key);
            freq++;
            mp.put(key,freq);
        }

        int q;
        System.out.println("Enter query number now : ");
        q = sc.nextInt();
        while (q-- > 0) {
            int number;
            number = sc.nextInt();
            // fetch:
            if (mp.containsKey(number)) System.out.println(mp.get(number));
            else System.out.println(0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases
        List<Integer> list = printDivisors(scanner,numTestCases);
        for(Integer i : list){
            System.out.print(i + " ");
        }
        Hashing(scanner);
    }
}
