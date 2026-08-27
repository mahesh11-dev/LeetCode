class Solution {
    private String checkLexicography(String resultStr, String str){
        if(resultStr.compareTo(str) < 0){
            return resultStr;
        }
        return str;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String resultStr = "";
        int i=0;
        int count1 = 0;
        //for(int j=0; j<n; j++){
        int j = 0;
        while( j < n){
            if(s.charAt(j) == '1'){
                count1++;
            }
            while(count1 > k || (i < n && s.charAt(i) == '0')){
                if(s.charAt(i) == '1')
                    count1--;
                i++;
            }
            if(count1 == k){
                String str = s.substring(i, j+1);
                if(resultStr.length() == 0 || str.length() < resultStr.length()){
                    resultStr = str;
                }else if(resultStr.length() == str.length()){
                    resultStr = checkLexicography(resultStr, str);
                }
            }
            j++;
            
        }
        return resultStr;
    }
}