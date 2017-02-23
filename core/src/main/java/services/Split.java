package services;

import java.nio.ByteBuffer;
import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class Split {
    public BitSet split(BitSet first, BitSet second) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(first.toByteArray());
        byteBuffer.put(second.toByteArray());
        return BitSet.valueOf(byteBuffer);
    }
}
