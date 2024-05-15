package Striver.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public static  int romanToInt(String s){
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        Map<Character,Integer> mp = new HashMap<>();
        mp.put( 'I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        for(int i = 0 ; i < s.length() ; ++i){
            if (list.isEmpty()){
                list.add(mp.get(s.charAt(i)));
            }
            else{
                int n = list.size();
                int lastVal = list.get(n-1);
                int curVal = mp.get(s.charAt(i));
                if(lastVal < curVal){
                    list.remove(n-1);
                    list.add(curVal - lastVal);
                }
                else{
                   list.add(curVal);
                }
            }
        }

        for(Integer i : list){
            ans += i;
        }

        return ans ;
    }
    public static void main(String[] args) {
        String s ="III";
        System.out.println(s + " : " + romanToInt(s));

        s = "LVIII";
        System.out.println(s + " : " + romanToInt(s));

        s="MCMXCIV";
        System.out.println(s + " : " + romanToInt(s));
    }
}
