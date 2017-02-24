package models;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
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
            numbers[numbers.length - 1 - i] = (byte) Integer.parseInt(tokens[i], 16);
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

    @Override
    public String toString() {
        long[] longs = bits.toLongArray();
        StringBuilder result = new StringBuilder();
        if (longs.length != 2) {
            result.append(Strings.repeat("0", Constants.HALF_OF_HEX_BLOCK));
            String representation = Long.toUnsignedString(longs[0], 16);
            result.append(Strings.repeat("0", Constants.HALF_OF_HEX_BLOCK - representation.length()));
            result.append(representation);
        } else {
            String first = Long.toUnsignedString(longs[1], 16);
            String second = Long.toUnsignedString(longs[0], 16);
            result.append(Strings.repeat("0", Constants.HALF_OF_HEX_BLOCK - first.length()));
            result.append(first);
            result.append(Strings.repeat("0", Constants.HALF_OF_HEX_BLOCK - second.length()));
            result.append(second);
        }
        return result.toString().toLowerCase();
    }

    public static void checkSize(byte[] hexBlocks) {
        if (hexBlocks.length != Constants.COUNT_OF_HEX_BLOCKS) {
            throw new IllegalArgumentException("Array has size " + hexBlocks.length +
                    " expected " + Constants.COUNT_OF_HEX_BLOCKS);
        }
    }
}