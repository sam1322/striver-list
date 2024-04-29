import java.util.*;

public class Throw {
//    public static void main(String[] args)  throws InterruptedException{
//        throw new NullPointerException("demo");
////        Thread.sleep(10000);
////        System.out.println("Hello Geeks");
//    }

    private static List<Integer> integers = new ArrayList<>();

    //    public static void addInteger(Integer value) {
    public static void addInteger(Integer value) throws IllegalArgumentException {
        if (integers.contains(value)) {
            throw new IllegalArgumentException("Integer already added.");
        }
        integers.add(value);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && k > 0; --i) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();

//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
//
//        // Sort the list in descending order based on values using a custom comparator
//        Collections.sort(entryList, Collections.reverseOrder(Map.Entry.comparingByValue()));
//
//        // int[] ints = Ints.toArray(list);
//        int[] arr = new int[k];
//        for(int i = 0 ; i < Math.min(entryList.size() , k) ; ++i){
//            arr[i] = entryList.get(i).getKey();
//        }
//        return arr ;

    }


    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        prefix[0] = 1;
        for (int i = 0; i < n - 1; ++i) {
            prefix[i + 1] = prefix[i] * nums[i];
        }
        suffix[n - 1] = 1;
        for (int j = n - 1; j > 0; --j) {
            suffix[j - 1] = suffix[j] * nums[j];
        }

        for (int i = 0; i < n; ++i) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    public static boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String str = "(" + board[i][j] + ")";
                    if (!set.add(str + i) || !set.add(str + j) || !set.add(i / 3 + str + j / 3)) {
//                        System.out.println(set.stream().toArray().toString());
                        for (String element : set) {
                            System.out.println("set element :" + element);
                        }

                        System.out.println(str + i);
                        System.out.println(str + j);
                        System.out.println(i / 3 + str + j / 3);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] sortedArray = set.stream().mapToInt(Integer::intValue).toArray();

        // Sort the array
        Arrays.sort(sortedArray);
        int mx = 1, cur = 1;
        for (int i = 1; i < sortedArray.length; ++i) {
            int a = sortedArray[i - 1];
            int b = sortedArray[i];
            if (a == b - 1) {
                cur++;
                mx = Math.max(mx, cur);
            } else {
                cur = 1;
            }
        }
        return mx;

    }

    public static void main(String[] args) {

//        int[] arr = new int[]{100, 4, 200, 1, 3, 2};

        int[] arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));


//        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
//        int[] arr = new int[]{1, 2, 3, 4, 5};
////        int[] newArr = topKFrequent(arr, 2);
//        int[] newArr = productExceptSelf(arr);
//        System.out.println(Arrays.toString(newArr));

//        char[][] sudokuArray = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//
//        System.out.println(isValidSudoku(sudokuArray));
    }
}
