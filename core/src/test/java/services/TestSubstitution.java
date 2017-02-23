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
        byte[] copy = Arrays.copyOf(bytes, bytes.length);
        Substitution.substitute(copy);
        Substitution.revertSubstitution(copy);
        Assert.assertArrayEquals(bytes, copy);
    }

    @Test
    public void testSubstitutionByValues() {
        Block input = new Block("ffeeddccbbaa99881122334455667700");
        Block expectedOutput = new Block("b66cd8887d38e8d77765aeea0c9a7efc");
        byte[] inputs = input.toHexArray();
        byte[] expectedOutPuts = expectedOutput.toHexArray();
        Substitution.substitute(inputs);
        Assert.assertArrayEquals(expectedOutPuts, inputs);
    }
}
