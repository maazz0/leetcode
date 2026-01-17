class Solution {
    public int alternatingXOR(int[] nums, int target1, int target2) {
    int mod = 1_000_000_007;
        
        // Maps map a PrefixXOR value -> Count of ways to reach that state
        // countT1: stores sum of ways ending in a completed Target1 segment
        // countT2: stores sum of ways ending in a completed Target2 segment
        Map<Integer, Integer> countT1 = new HashMap<>();
        Map<Integer, Integer> countT2 = new HashMap<>();
        
        // Base Case: logically "ended" with T2 at index -1, ready for T1.
        countT2.put(0, 1);
        
        int currentXor = 0;
        long waysEndT1 = 0;
        long waysEndT2 = 0;

        for (int num : nums) {
            currentXor ^= num;
            
            
            int needForT1 = currentXor ^ target1;
            waysEndT1 = countT2.getOrDefault(needForT1, 0);
            
            // To form a new T2 segment ending here, we look for a prev state ending in T1
            int needForT2 = currentXor ^ target2;
            waysEndT2 = countT1.getOrDefault(needForT2, 0);
            
            // Update the DP state maps for the current prefix
            if (waysEndT1 > 0) {
                countT1.put(currentXor, (int)((countT1.getOrDefault(currentXor, 0) + waysEndT1) % mod));
            }
            if (waysEndT2 > 0) {
                countT2.put(currentXor, (int)((countT2.getOrDefault(currentXor, 0) + waysEndT2) % mod));
            }
        }
        
        // Result is the valid ways ending at the final element
        return (int)((waysEndT1 + waysEndT2) % mod);
    
    }
}
