package Striver.Recursions;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    public static ArrayList<Integer>  subsetSum(int[] num,int i){
        if(i==num.length ){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(0);
            return arr;
//            return new ArrayList<>(1);
        }
        ArrayList<Integer> arr = subsetSum(num,i+1);
        int n = arr.size();
//        arr.add(num[i]);
        for(int j = 0 ; j < n ; ++j){
            arr.add(arr.get(j)+num[i]);
        }
        return arr;
    }
    public static void subsetSum(int ind,int cur,int[] nums , ArrayList<Integer> list){
        if(ind == nums.length){
            list.add(cur);
            return ;
        }
        subsetSum(ind+1,cur,nums,list);
        subsetSum(ind+1,cur + nums[ind],nums,list);
    }
    public static ArrayList<Integer> subsetSum(int[] num){
//        ArrayList<Integer> soln = subsetSum(num,0);
        ArrayList<Integer> soln = new ArrayList<>();
        subsetSum(0,0,num,soln);
        Collections.sort(soln);
        return soln;
    }


    public static void PrintList(ArrayList<Integer>arr){
        System.out.println("Hey");
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] num = {5,2,1};
        ArrayList<Integer> soln = subsetSum(num);
        PrintList(soln);
    }
}
