class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        // for(String str : words){
        //     if(str.startsWith(pref)){
        //         count++;
        //     }
        // }
        int len = pref.length();
        for(String str : words){
            if(len <= str.length()){
                String sub = str.substring(0, len);
                if(sub.equals(pref)){
                    count++;
                }
            }
        }
        return count;
    }
}