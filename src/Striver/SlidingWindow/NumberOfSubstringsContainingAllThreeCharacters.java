package Striver.SlidingWindow;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int cnt = 0, n = s.length();
        int[] arr = {-1, -1, -1};
        for (int i = 0; i < n; ++i) {
            int ch = s.charAt(i) - 'a';
            arr[ch] = i;
            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                cnt += 1 + Math.min(arr[0], Math.min(arr[1], arr[2]));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println(numberOfSubstrings(str));
    }
}
