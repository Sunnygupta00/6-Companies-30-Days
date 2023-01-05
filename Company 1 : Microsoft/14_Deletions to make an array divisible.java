  public int minOperations(int[] nums, int[] numsDivide) {
        int g = IntStream.of(numsDivide).reduce(numsDivide[0], (a, b) -> gcd(a, b));
        int minOp = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (g % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

// Time Complexity O(nlogn)+ O(n)
