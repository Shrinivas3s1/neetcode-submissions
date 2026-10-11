class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        int[] freq = new int[26];

        for(char c : s1.toCharArray()){
           freq[c - 'a']++;
        }

        int right=0;
        int left=0;
        while(right < m){
        char ch = s2.charAt(right);
        freq[ch - 'a']--;
        while(freq[ch -'a'] < 0){
            freq[s2.charAt(left)-'a']++;
            left++;
        }

        if(right-left + 1 == n){
            return true;
        }
        right++;
        }
        return false;
    }
    
}
