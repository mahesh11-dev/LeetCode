class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

            if(leftMax < rightMax){
                int water = leftMax - height[left];
                totalWater += water;
                left++;
            }else{
                int water = rightMax - height[right];
                totalWater += water;
                right--;
            }
        }
        return totalWater;
    }
}