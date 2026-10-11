class Solution {
public String minWindow(String s, String t) {

        // Edge case
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Store frequency of characters required
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if this character requirement is satisfied
            if (countT.containsKey(c)
                    && window.get(c).intValue() == countT.get(c).intValue()) {
                have++;
            }

            // Shrink window while valid
            while (have == need) {

                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (countT.containsKey(leftChar)
                        && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}
