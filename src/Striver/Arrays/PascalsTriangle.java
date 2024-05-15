package Striver.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        result.add(generateNewList(arr));
        for (int i = 1; i < numRows; ++i) {
            arr.add(1);
//            System.out.print("before : ");
//            System.out.println(arr);

            for (int j = i - 1; j > 0; --j) {
                int num = arr.get(j) + arr.get(j - 1);
                arr.set(j, num);
//                System.out.println("j : " + j + ", num :  " + num);
            }
//            System.out.print("after : ");
//            System.out.println(arr);
            result.add(generateNewList(arr));
        }
        return result;
    }

    public static List<Integer> generateNewList(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for(Integer i : list)newList.add(i);
        return newList;
    }

    public  static  void PrintList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void PrintListofList(List<List<Integer>> list) {
        for (List<Integer> cur : list) {
            PrintList(cur);
        }
    }

    public static void main(String[] args) {
        PrintListofList(generate(4));
    }
}
