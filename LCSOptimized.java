public class LCSOptimized {
    public static int findLCSLength(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[] previous = new int[n + 1];  // Previous row
        int[] current = new int[n + 1];   // Current row

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    current[j] = 1 + previous[j - 1]; // Take from diagonal
                } else {
                    current[j] = Math.max(previous[j], current[j - 1]); // Max of top or left
                }
            }
            // Swap current and previous for next iteration
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[n]; // LCS length is stored in previous[n]
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int lcsLength = findLCSLength(str1, str2);
        System.out.println("LCS Length: " + lcsLength);
    }
}
