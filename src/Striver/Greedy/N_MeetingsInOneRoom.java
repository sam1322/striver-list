package Striver.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class N_MeetingsInOneRoom {
    public static List<Integer[]> N_Meetings(int[] start, int[] end) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < start.length; ++i) {
            list.add(new Integer[]{start[i], end[i]});
        }
        list.sort(((a, b) ->
                a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        ));
        List<Integer[]> newList = new ArrayList<>();
        int low = 0 , high = 0 ;

        for(int i = 0 ; i < list.size() ; ++i){
            Integer[] cur = list.get(i);
            if(high < cur[0] ){
                high = Math.max(high,cur[1]);
                newList.add(cur);
            }
        }
//        return list;
        return newList;
    }

    public static void main(String[] args) {
//        int[] start = {1, 3, 0, 5, 8, 5};
//        int[] end = {2, 4, 6, 7, 9, 9};
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] start = new int[N];
        int[] end = new int[N];
        for(int i =0 ; i < N ; ++i) start[i] = scanner.nextInt();
        for(int i =0 ; i < N ; ++i) end[i] = scanner.nextInt();

        List<Integer[]> list =N_Meetings(start,end);
        for(Integer[] i : list){
            System.out.print("{ " + i[0] + ", " + i[1] + " }, ");
        }
        System.out.println();

    }
}
