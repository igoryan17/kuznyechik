package services;

import models.Block;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class TestPermutation {
    private long[] blocks = new long[] {1343, 32543};

    @Test
    public void testPermutationsAndReverts() {
        BitSet bitSet = BitSet.valueOf(blocks);
        Block block = new Block(bitSet);
        byte[] bytes = block.toHexArray();
        byte[] actual;
        actual = Permutation.replace(bytes);
        actual = Permutation.revertReplacing(actual);
        Assert.assertArrayEquals(bytes, actual);
    }

    @Test
    public void testGivenValues() {
        String input = "00000000000000000000000000000100";
        Block inputBlock = new Block(input);

        String expectedOutput = "94000000000000000000000000000001";
        Block expectedOutputBlock = new Block(expectedOutput);

        byte[] result = Permutation.replace(inputBlock.toHexArray());
        Assert.assertEquals(expectedOutputBlock.getBits(), BitSet.valueOf(result));
    }
}
