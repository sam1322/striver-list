package Striver.BinarySearch;

public class NthRoot {

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public static int nthRoot(int n ,int m ){
//        int pow = 1;
//        int x = 1;
//        for(;pow*n<=m;++x){
//            pow*=n;
//            if(pow == m)return x;
//        }
//        return -1;
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = nthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }
}
