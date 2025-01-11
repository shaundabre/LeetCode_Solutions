class Solution {
    //RECURSIVE + MEMOIZATION APPROACH
    int [][] dp;

    public boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (dp[start][end] != 0) {
            return dp[start][end] == 1;  // Return true if palindrome, false otherwise
        }

        boolean isPalin = false;
        if (s.charAt(start) == s.charAt(end)) {
            isPalin = isPalindrome(s, start + 1, end - 1);
        }

        dp[start][end] = isPalin ? 1 : 0;  // Memoize result as 1 (palindrome) or 0 (not a palindrome)
        return isPalin;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int startIdx = 0;
        int endIdx = 0;

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int currentLen = j - i + 1;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        startIdx = i;
                        endIdx = j;
                    }
                }
            }
        }
        return s.substring(startIdx, endIdx + 1);
    }

    // ITERATIVE APPROACH
    // public boolean isPalindrome(String s, int start, int end) {
    //     while (start <= end) {
    //         if (s.charAt(start) != s.charAt(end)) {
    //             return false;
    //         }
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }

    // public String longestPalindrome(String s) {
    //     int n = s.length();
    //     int maxLen = 0;
    //     int startIdx = 0;
    //     int endIdx = 0;

    //     for (int i=0; i<n; i++) {
    //         for (int j=i; j<n; j++) {
    //             if (isPalindrome(s, i, j)) {
    //                 int currentLen = j-i+1;
    //                 if (currentLen > maxLen) {
    //                     maxLen = currentLen;
    //                     startIdx = i;
    //                     endIdx = j;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(startIdx, endIdx+1);
    // }
}
