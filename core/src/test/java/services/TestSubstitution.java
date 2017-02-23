package services;

import models.Block;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class TestSubstitution {
    private long[] blocks = new long[] {1343, 32543};

    @Test
    public void testSmokeSubstitution() {
        BitSet bitSet = BitSet.valueOf(blocks);
        Block block = new Block(bitSet);
        byte[] bytes = block.toHexArray();
        System.out.println();
        byte[] copy = Arrays.copyOf(bytes, bytes.length);
        Substitution.substitute(copy);
        Substitution.revertSubstitution(copy);
        Assert.assertArrayEquals(bytes, copy);
    }
}
