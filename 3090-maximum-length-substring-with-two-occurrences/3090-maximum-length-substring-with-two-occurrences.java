class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0, j=0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0) + 1);

            while(map.get(s.charAt(j)) > 2){
                char left = s.charAt(i);
                map.put(left, map.get(left)- 1);
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);

            j++;
        }
        return maxLen;
    }
}