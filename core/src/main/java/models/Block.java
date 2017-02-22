package models;

import java.nio.ByteBuffer;
import java.util.BitSet;

/**
 * Created by igoryan on 22.02.2017.
 */
public class Block {
    private final BitSet bits = new BitSet(Constants.SIZE_OF_BLOCKS);

    public short[] toHexArray() {
        short[] result = new short[Constants.COUNT_OF_HEX_BLOCKS];
        for (int i = 0; i < result.length; ++i) {
            ByteBuffer byteBuffer = ByteBuffer.wrap(bits.toByteArray());
            result[i] = byteBuffer.getShort(2 * i);
        }
        return result;
    }
}
