class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0, j=0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();

        while(j < n){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            len = Math.max(len, j-i+1);
            j++;
        }
        return len;
    }
}
