package Striver.Arrays;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices){
        int mx = 0;
        int n = prices.length ;
        int profit = 0 ;
        for(int i = n - 1; i >=0 ; --i){
            profit = Math.max(profit, mx - prices[i]);
            mx = Math.max(mx,prices[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
//        int[] nums = {7,1,5,3,6,4};
        int[] nums = {7,6,4,31};
        ArrayImpl.printArr(nums);
        System.out.println("max profit " + maxProfit(nums));
    }
}
