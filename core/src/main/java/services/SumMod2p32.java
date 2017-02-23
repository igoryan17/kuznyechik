package services;

import java.util.BitSet;

/**
 * Created by Alexander on 23.02.2017.
 */
public class SumMod2p32 {
    public static BitSet sum(BitSet first, BitSet second) {
        BitSet result = new BitSet(32);

        boolean carry = false;

        for (int i = 0; i < 32; ++i) {
            boolean first_bit = (i < first.length()) ? first.get(i) : false;
            boolean second_bit = (i < second.length()) ? second.get(i) : false;

            boolean bit = first_bit ^ second_bit ^ carry;
            carry = first_bit & second_bit | first_bit & carry | second_bit & carry;

            result.set(i, bit);
        }

        return result;
    }
}
