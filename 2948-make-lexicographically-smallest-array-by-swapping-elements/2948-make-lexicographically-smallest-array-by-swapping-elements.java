class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Store value and its original index
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort according to value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0;

        while(i < n){

            int j = i;

            // Find the group
            while(j + 1 < n &&
                  arr[j + 1][0] - arr[j][0] <= limit){
                j++;
            }

            // Get original indices
            ArrayList<Integer> index = new ArrayList<>();

            for(int x = i; x <= j; x++){
                index.add(arr[x][1]);
            }

            // Sort original indices
            Collections.sort(index);

            // Put sorted values at sorted indices
            int k = 0;

            for(int x = i; x <= j; x++){
                nums[index.get(k)] = arr[x][0];
                k++;
            }

            i = j + 1;
        }

        return nums;
    }
}