package Striver.BinarySearch;

public class SearchSingleElementInASortedArray {
    public static int findSingleElement(int[] arr) {
        int n = arr.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if ((md == 0 || arr[md] != arr[md - 1]) && (md == n - 1 || arr[md] != arr[md + 1])) {
                return md;
            } else if ((md % 2 == 0 && arr[md] == arr[md + 1]) || md % 2 != 0 && arr[md] == arr[md - 1]) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        int[] arr = {1,1,2,2,3};
        int ind= findSingleElement(arr);
        System.out.println(arr[ind]);
    }
}
