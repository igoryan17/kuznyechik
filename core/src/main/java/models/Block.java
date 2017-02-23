package models;

import java.util.BitSet;

/**
 * Created by igoryan on 22.02.2017.
 */
public class Block {
    private BitSet bits;

    public Block(BitSet bits) {
        checkBitSetSize(bits);
        this.bits = bits;
    }

    public byte[] toHexArray() {
        byte[] result = bits.toByteArray();
        checkSize(result);
        return result;
    }

    public void merge(byte[] hexBlocks) {
        checkSize(hexBlocks);
        bits = BitSet.valueOf(hexBlocks);
    }

    public static void checkSize(byte[] hexBlocks) {
        if (hexBlocks.length != Constants.COUNT_OF_HEX_BLOCKS) {
            throw new IllegalArgumentException("Array has size " + hexBlocks.length +
                    " expected " + Constants.COUNT_OF_HEX_BLOCKS);
        }
    }

    public static void checkBitSetSize(BitSet bits) {
        if (bits.length() != Constants.SIZE_OF_BLOCKS) {
            throw new IllegalArgumentException("BitSet has size " + bits.length() +
                    " expected " + Constants.SIZE_OF_BLOCKS);
        }
    }
}