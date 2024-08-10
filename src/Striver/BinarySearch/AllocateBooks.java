package Striver.BinarySearch;

public class AllocateBooks {
    public static int findPages(int[] arr, int m) {
        int n = arr.length, sum = 0, max = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        for (int pages = max; pages <= sum; ++pages) {
            if (count(arr, pages) == m) {
                return pages;
            }
        }
        return -1;
    }

    public static int count(int[] arr, int pages) {
        int stu = 0, pageCount = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            if (pageCount + arr[i] <= pages) {
                pageCount += arr[i];
            } else {
                stu++;
                pageCount = arr[i];
            }
        }
        if (pageCount > 0) stu++;
        return stu;
    }

    public static int findPagesByBS(int[] arr, int m) {
        int n = arr.length, sum = 0, max = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        int low = max, high = sum;
        while(low <= high){
            int mid = (low + high)>>1;
            int cnt =count(arr, mid);
            if ( cnt== m) {
                return mid;
            }
            else if(cnt < m) {
                high = mid  - 1;
            }
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int m = 4;
        System.out.println(findPagesByBS(arr, m));

    }
}
