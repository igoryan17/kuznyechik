package services;

import models.Block;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class TestSubstitution {
    private long[] blocks = new long[] {1343, 32543};

    @Test
    public void testSmokeSubstitution() {
        BitSet bitSet = BitSet.valueOf(blocks);
        bitSet.set(127);
        Block block = new Block(bitSet);
        Substitution.substitute(block.toHexArray());
    }
}
