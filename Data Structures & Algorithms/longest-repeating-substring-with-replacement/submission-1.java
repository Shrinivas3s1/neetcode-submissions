class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxwindow=0;
        int maxfreq=0;
        int[] charcount = new int[26];

        for(int right=0; right<s.length(); right++){
           charcount[s.charAt(right) - 'A']++;
           maxfreq = Math.max(maxfreq,charcount[s.charAt(right) - 'A'] );
           int windowlength = right - left + 1;
           if(windowlength - maxfreq > k){
            charcount[s.charAt(left) - 'A']--;
            left++;
           }

           maxwindow = Math.max(maxwindow, right - left +1);
       
        }

        return maxwindow;
    }
}
