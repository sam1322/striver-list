import java.util.PriorityQueue;

public class Ques {

    public static void newQuest(){
        String s = "aabacbebebe";
//         no of substring with exactly k different unique characters
        int k = 3 ;

//      longest substring with exactly k unique characters
//        i = 0 - n
//                j = i+1 - n
//                        str = i to j
        // 0 1 2 3
        // a a b a c d e f a b c d e
        int[] mp = new int[256];
        int n = s.length();
        int cnt = 0 ;
        int low = 0 ;
        int ans = 0 , i ;
        for( i = 0 ; i < n ; ++i){
         if(cnt==k) {
             ans = i ;
             break;
         }
            if(mp[s.charAt(i)]==0)cnt++;
            mp[s.charAt(i)]=i;
        }

    }



    public static void main(String[] args) {
        int[] arr = {4,5,6, 7 ,0,1,2};
        //sorted array   find an  element

//        low   mid  target  high
        // 7 , 0 , 1, 2    1 target
        // 7  , 8, 0 , 1, 2        mid = 1 , target = 8
//        4 , 5, 6,7,8,9,10,0,1,2,3

                // pivot position whhere it
        // brute force solution
        // O(N)

        // low = 4 high = 2 , target = 0
        int n = arr.length;
        int low = 0 , high = n - 1;
        int target = 0 , pivot = 0;
        while(low <= high){
            int mid = (low + high )/2;
            if( arr[low]<=arr[mid]){
                low = mid + 1 ;
                pivot = low ;
            }else{
                high = mid ;
            }
        }

//       operator  overloading
// function

//        class a
//         public:
//            fn()
//
//            class b : a
//                public:
//                    fn()
//        virtual function
//        class A{
//            public:
//            int n , m;
//            A(){
//
//            }
//            A(int n,int m){
//                this.
//            }
//            A(A &B){
//                this.n = B.n
//                this.m = B.m;
//            }
//        }

        //        copy constructor
        // pure virtual functions
//        array and vector
        //
    }
}
