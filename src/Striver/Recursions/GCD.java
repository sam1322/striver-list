package Striver.Recursions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GCD {
    public int gcd(int a,int b){
        if(b==0)return  a;
        return gcd(b,a%b);
    }

    public int findGCD(int[] nums) {
//        int a = nums[0];
//        for(int i = 1; i< nums.length ;++i){
//            a = gcd(a,nums[i]);
//        }
//        return a;


        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return gcd(min,max);
    }

    public static void main(String[] args) {
        int[] num = {2,5,6,9,10};
        GCD gcd = new GCD();
        int ans = gcd.findGCD(num);
        System.out.println("ans = " + ans);
    }
}
