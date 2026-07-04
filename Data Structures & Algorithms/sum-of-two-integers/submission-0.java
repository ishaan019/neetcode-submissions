class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = a & 1;
            int bitB = b & 1;

            int sumBit = bitA ^ bitB ^ carry;

            res |= (sumBit << i);

            carry = (bitA & bitB) | (carry & (bitA ^ bitB));

            a >>>= 1;
            b >>>= 1;
        }

        return res;
    }
}