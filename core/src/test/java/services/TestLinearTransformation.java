package services;

import models.Block;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class TestLinearTransformation {
    private long[] blocks = new long[] {1343, 32543};

    @Test
    public void testSmokeTransform() {
        BitSet bitSet = BitSet.valueOf(blocks);
        Block block = new Block(bitSet);
        byte[] bytes = block.toHexArray();
        LinearTransformation.transform(bytes);
    }
}
