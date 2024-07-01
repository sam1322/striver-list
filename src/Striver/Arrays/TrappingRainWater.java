package Striver.Arrays;

public class TrappingRainWater {
    public static int trappingRainWater(int[] height ){
        int leftMax = 0 ,rightMax= 0;
        int n = height.length ;
        int left = 0 ,ans  = 0 , right = n - 1;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] > leftMax ){
                    leftMax  = height[left];
                }
                else {
                    ans+=leftMax - height[left];
                }
                left++;
            }
            else{
                if(height[right] > rightMax ){
                    rightMax  = height[right];
                }
                else {
                    ans+=rightMax - height[right];
                }
                right--  ;
            }
        }
        return ans ;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The water that can be trapped is " + trappingRainWater(arr));
    }
}
