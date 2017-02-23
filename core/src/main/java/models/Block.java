package models;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.BitSet;

/**
 * Created by igoryan on 22.02.2017.
 */
public class Block {
    private BitSet bits;

    public Block(BitSet bits) {
        this.bits = bits;
    }

    public Block(String hexString) {
        String[] tokens = Iterables.toArray(
                Splitter.fixedLength(2).split(hexString),
                String.class
        );
        byte[] numbers = new byte[Constants.COUNT_OF_HEX_BLOCKS];
        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = (byte) Integer.parseInt(tokens[i], 16);
        }
        bits = BitSet.valueOf(numbers);
    }

    public Block(long number) {
        this.bits = BitSet.valueOf(new long[] {number});
    }

    public byte[] toHexArray() {
        byte[] result = bits.toByteArray();
        if (result.length > Constants.COUNT_OF_HEX_BLOCKS) {
            throw new IllegalArgumentException("incorrect count of bytes");
        } else if (result.length < Constants.COUNT_OF_HEX_BLOCKS) {
            byte[] completed = new byte[Constants.COUNT_OF_HEX_BLOCKS];
            System.arraycopy(result, 0, completed, 0, result.length);
            checkSize(completed);
            return completed;
        }
        checkSize(result);
        return result;
    }

    public void update(byte[] hexBlocks) {
        checkSize(hexBlocks);
        bits = BitSet.valueOf(hexBlocks);
    }

    public BitSet getBits() {
        return bits;
    }

    public static void checkSize(byte[] hexBlocks) {
        if (hexBlocks.length != Constants.COUNT_OF_HEX_BLOCKS) {
            throw new IllegalArgumentException("Array has size " + hexBlocks.length +
                    " expected " + Constants.COUNT_OF_HEX_BLOCKS);
        }
    }
}