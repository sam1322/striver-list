package Striver.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < stalls.length; ++i) {
            if (stalls[i] - lastPos >= dist) {
                cntCows++;
                lastPos = stalls[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int limit = stalls[n-1] - stalls[0];
//        for(int i = limit ; i >= 1; --i){
//            if(canWePlace(stalls, i, k)){
//                return i;
//            }
//        }

        int low = 1 , high = limit;
        while(low <= high){
            int mid = (low + high)/2;
            if(canWePlace(stalls, mid, k)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high ;

//        return -1;
    }



    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);

    }
}
