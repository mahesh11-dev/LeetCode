class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        if(x < 0){
            return false;
        }
        int revNo = 0;
        while(x != 0){
            int lastDigit = x % 10;
            revNo = (revNo * 10) + lastDigit;
            x = x / 10;
        }
        if(revNo == temp)
            return true;
        return false;
    }
}