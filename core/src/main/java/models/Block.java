package models;

import java.util.BitSet;

/**
 * Created by igoryan on 22.02.2017.
 */
public class Block {
    private BitSet bits;

    public Block(BitSet bits) {
        this.bits = bits;
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
            System.arraycopy(result, 0, completed, completed.length - result.length, result.length);
            checkSize(completed);
            return completed;
        }
        checkSize(result);
        return result;
    }

    public void merge(byte[] hexBlocks) {
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