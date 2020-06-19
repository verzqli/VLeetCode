package me.verzqli.leetcode.everyday;

class LeetCode20200619 {

    public boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left > right) {
                break;
            }
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            }else{
                return false;
            }
        }
        return  true;
    }
}
