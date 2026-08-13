class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(ans.size() == 0 || intervals[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
                continue;
            }
            ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}