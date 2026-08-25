class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int gasSum = 0;
        int costSum = 0;
        for(int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(costSum > gasSum) {
            return -1;
        }

        int res = 0;
        int totalGasLeft = 0;

        for(int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            
            totalGasLeft += diff;

            if(totalGasLeft < 0) {
                totalGasLeft = 0;
                res = i + 1;
            }
        }

        return res;
    }
}
