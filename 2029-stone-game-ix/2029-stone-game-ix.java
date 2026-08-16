class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for(int num : stones){
            int remainder = num % 3;
            count[remainder]++;
        }
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        } else {
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
}