import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        while(j < n){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }
}