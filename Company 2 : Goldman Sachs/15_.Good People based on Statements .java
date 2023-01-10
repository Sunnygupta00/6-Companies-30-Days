class Solution {
    public int maximumGood(int[][] A) {
        int n = A.length, ans = 0;
        for (int num = 0; num < 1 << (n); num++) {
            if (check(num, A, n)) {
                int count = Integer.bitCount(num);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
    
    private boolean check(int mask, int[][] A, int n) {
        for (int i = 0; i < n; i++) {
            if ((mask >> (n - 1 - i) & 1) == 0) continue;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 2) continue;
                if ((A[i][j] == 1 && (mask >> (n - 1 - j) & 1) == 0) || 
                    (A[i][j] == 0 && (mask >> (n - 1 - j) & 1) == 1)) 
                    return false;
            }
        }
        return true;
    }
}
