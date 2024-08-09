package Striver.SlidingWindow;

public class MaxConsecutiveOnesIII {
    public static int maxConsecutiveOnesIII(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int ans = 0, cur = 0, tempK = k;
        while (right < n) {
            if (nums[right] == 1) {
            } else {
                if (cur >= k) {
                    while (left <= right && cur >= k) {
                        if (nums[left] == 0) {
                            cur--;
                            left++;
                            break;
                        }
                        left++;
                    }
                }

                if (cur < k) {
                    cur++;
                }

            }
            ans = Math.max(right - left + 1, ans);
            right++;
        }

//        while (right < n) {
//            if (nums[right] == 1) {
//                cur++;
//            } else {
//                if (tempK > 0) {
//                    tempK--;
//                    cur++;
//                } else if (k > 0 && tempK == 0) {
//                    while (left < right && tempK == 0) {
//                        if (nums[left] == 0) {
//                            tempK++;
//                        } else {
//                        }
//                        left++;
//                        cur--;
//                    }
//                    if (tempK == 0) {
//                        cur = 0;
//                    }
//                    else{
//                        cur++;
//                    }
//                } else {
//                    cur = 0;
//                }
//            }
//            right++;
//            ans = Math.max(ans, cur);
//
//        }
        return ans;
    }

    public static int striver_soln1(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, zeroes = 0, maxLen = 0;
        while (r < n) {
            if (nums[r] == 0) zeroes++;
            while (zeroes > k) {
                if (nums[l] == 0) zeroes--;
                l++;
            }
            if (zeroes <= k) {
                int ans = r - l + 1;
                maxLen = Math.max(maxLen, ans);
            }
            r++;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 0, 1, 1, 1};
        int k = 3;
        arr = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        k = 2;
        int ans = maxConsecutiveOnesIII(arr, k);
        int ans1 = striver_soln1(arr, k);
        System.out.println("The maximum number of consecutive 1s is " + ans + ", " + ans1);

        arr = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        ans = maxConsecutiveOnesIII(arr, k);
        ans1 = striver_soln1(arr, k);

        System.out.println("The maximum number of consecutive 1s is " + ans + ", " + ans1);
    }
}
