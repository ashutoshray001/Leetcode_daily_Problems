class Solution {
    public int characterReplacement(String s, int k) {

        int arr[] = new int[26];

        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int ans = 0;

        while(j < s.length()) {

            arr[s.charAt(j) - 'A']++;

            maxFreq = Math.max(maxFreq, arr[s.charAt(j) - 'A']);

            while((j - i + 1) - maxFreq > k) {

                arr[s.charAt(i) - 'A']--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }
}