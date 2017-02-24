package services;

import models.Block;
import org.junit.Assert;
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

    @Test
    public void testTransform() {
        testTransformValues("00000000000000000000000000000100", 0x94);
        testTransformValues("94000000000000000000000000000001", 0xA5);
    }

    public void testTransformValues(String hexString, int expected) {
        Block block = new Block(hexString);
        byte[] bytes = block.toHexArray();
        byte result = LinearTransformation.transform(bytes);
        Assert.assertEquals(expected, Byte.toUnsignedInt(result));
    }
}
