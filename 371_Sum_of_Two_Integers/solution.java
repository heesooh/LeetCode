class Solution {
    public int getSum(int a, int b) {
        // Java int is 32 bit
        // to calculate sum in binary -> bitwise op
        // XOR to add the binary values 
        // AND to calculate the carryover
        // a holds XOR value & b holds carryover value
        // we then XOR & AND the new "a" and "b" until b = 0;

        // while the carryover value != 0; stored in "b"
        while (b != 0) {
            int carryOver = (a & b) << 1;
            a = a ^ b; // XOR
            b = carryOver;
        }

        // final result is stored in a
        return a;
    }
}

// Time: O(n)
// Space: O(1)