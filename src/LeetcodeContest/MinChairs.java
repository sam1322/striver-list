package LeetcodeContest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinChairs {
    public static int minChairs(String s) {
        int mx = 0, c = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'E') c++;
            else c--;
            mx = Math.max(mx, c);
        }
        return mx;
    }

    public static int countDays(int days, int[][] meetings) {
        int ans = 0;
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int prev = 1, k = 1;
        ans += meetings[0][0] - prev;

        System.out.println(meetings[0][0]);
        prev = Math.max(prev, meetings[0][1]);
        for (int j = 1; j < meetings.length; ++j) {
            int[] i = meetings[j];
            if (i[0] > prev + k) ans += i[0] - prev - 1;
            System.out.println(i[0] + " : " + i[1] + " : " + prev + " :" + ans);
            prev = Math.max(prev, i[1]);
        }
        if (days > prev) ans += days - prev;
        return ans;
    }

    public static String clearStars(String s) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch != '*') {
                pq.add(new Integer[]{ch - 'a', i});
            } else {
//                while (!pq.isEmpty()) {
//                    Integer[] arr = pq.poll();
//                    System.out.println(arr[0] + " " + arr[1]);
//                }
                Integer[] arr = pq.poll();
                System.out.println("pq " + arr[0] + " : " + arr[1]);
                int pos = arr[1];
                System.out.println("pos" + pos);
                set.add(pos);
            }
        }
        String str = "";
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '*' && !set.contains(i)) {
                str += s.charAt(i);
            }
        }
        System.out.println(set);
        return str;
    }

    public static void main(String[] args) {
        String s = "EEEELELEL";
//        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
//        int days = 10;
//       int days = 5;
//        int[][] meetings = {{2, 4}, {1, 3}};
        int days = 8;
        int[][] meetings = {{3, 4}, {4, 8}, {2, 5}, {3, 8}};
        System.out.println(countDays(days, meetings));

        s = "aaba*";

        System.out.println(clearStars(s));

    }
}
