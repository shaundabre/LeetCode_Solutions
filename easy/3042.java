// class Solution {
//     public int countPrefixSuffixPairs(String[] words) {
//         int n = words.length;
//         int result = 0;

//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 if(words[i].length() <= words[j].length() && isPrefixAndSuffix(words[i], words[j])){
//                     result++;
//                 }
//             }
//         }
//         return result;
//     }
    
//     public boolean isPrefixAndSuffix(String check, String s){
//         int n = check.length();
//         int m = s.length();

//         int prefix = s.indexOf(check);
        
//         if(prefix == -1 || prefix != 0){
//             return false;
//         }

//         int suffix = s.lastIndexOf(check);

//         if(suffix == -1 || suffix + n != m){
//             return false;
//         }

//         return true;
//     }
// }

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int result = 0;

        // Iterate over all pairs of words
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // Avoid comparing a word with itself and check prefix-suffix condition
                if (isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isPrefixAndSuffix(String check, String s) {
        // Check if 'check' is both a prefix and a suffix of 's'
        return s.startsWith(check) && s.endsWith(check);
    }
}
