// Time: O(1) since all n are of length 32
// Space: O(1)
public class Solution {
    // Last attempt: 
    // subtracting 1 from the integer n flips the least significant digit
    // e.g: 100100 subtract 1 => 100011
    // n AND n-1 => 100000
    // we can then update n to n-1 and repeat the above step 
    // until n = 0;
    public int hammingWeight(int n) {
        int counter = 0; 

        while (n != 0) {
            counter++;
            n = (n & (n-1));
        }

        return counter;
    }

    // Second attempt: bit masking
    public int hammingWeight_masking(int n) {
        int mask = 1;
        int counter = 0;

        for (int i=0; i<32; i++) {
            if ((mask & n) != 0) {
                counter++;
            }
            mask = mask << 1;
        }

        return counter;
    }

    // Initial: you need to treat n as an unsigned value
    public int hammingWeight_initial(int n) {
        String binaryString = Integer.toBinaryString(n);
        int counter = 0;

        for (int i=0; i<binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                counter++;
            }
        }

        return counter;
    }
}
