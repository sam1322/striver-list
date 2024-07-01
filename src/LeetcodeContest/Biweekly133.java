package LeetcodeContest;

public class Biweekly133 {
    public static int minimumOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 3 != 0) {
                if ((nums[i] - 1) % 3 == 0 || (nums[i] + 1) % 3 == 0) ans++;
                else {
                    ans += 2;
                }
            }
        }
        return ans;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] == 0) {
                ans++;
                for (int j = i; j < i + 3; j++) {
                    nums[j] = nums[j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) return -1;
        }
        return ans;
    }

    public static int minOperationsII(int[] nums) {
        int n = nums.length;
        int ans = 0, flips = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] == 0 && flips % 2 == 0) || (nums[i] == 1 && flips % 2 == 1)) {
                ans++;
                flips++;
                nums[i] = 1;
            } else if (nums[i] == 0 && flips % 2 == 1) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(minimumOperations(arr));
//        int[] arr1 = {0, 1, 1, 1, 0, 0};
        int[] arr1 = {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1};
        System.out.println(minOperations(arr1));

//        int[] arr2 = {0,1,1,0,1};
        int[] arr2 = {1, 0, 0, 0};
        System.out.println(minOperationsII(arr2));
    }
}
