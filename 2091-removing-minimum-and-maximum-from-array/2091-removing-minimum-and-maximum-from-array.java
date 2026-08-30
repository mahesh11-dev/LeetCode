class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int minIdx = 0;
        int maxIdx = 0;
        for(int i=1; i<n; i++){
            if(nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
            if(nums[i] < nums[minIdx]){
                minIdx = i;
            }
        }
        int leftIdx = Math.min(minIdx, maxIdx);
        int rightIdx = Math.max(minIdx, maxIdx);

        int front = rightIdx + 1;
        int back = n - leftIdx;
        int frontBack = (leftIdx+1)+(n-rightIdx);

        return Math.min(frontBack, Math.min(front, back));
    }
}