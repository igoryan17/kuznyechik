package services;

import models.Block;
import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class TestPermutation {
    private long[] blocks = new long[] {1343, 32543};

    //Doesn't work: seems like revert replace isn't working
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
        String input = "a5940000000000000000000000000000";
        Block inputBlock = new Block(input);

        String expectedOutput = "64a59400000000000000000000000000";
        Block expectedOutputBlock = new Block(expectedOutput);

        byte[] result = Permutation.replace(inputBlock.toHexArray());
        Assert.assertArrayEquals(expectedOutputBlock.toHexArray(), result);
    }

    @Test
    public void testGivenValuesReverse() {
        String input = "94000000000000000000000000000001";
        Block inputBlock = new Block(input);

        String expectedOutput = "00000000000000000000000000000100";
        Block expectedOutputBlock = new Block(expectedOutput);

        byte[] result = Permutation.revertReplacing(inputBlock.toHexArray());
        Assert.assertArrayEquals(expectedOutputBlock.toHexArray(), result);
    }
}
