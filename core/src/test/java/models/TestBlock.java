package models;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by Alexander on 24.02.2017.
 */
public class TestBlock {
    @Test
    public void TestHexInit() {
        BitSet expected = new BitSet(4);
        Block current = new Block("a");

        expected.set(1);
        expected.set(3);

        Assert.assertArrayEquals(expected.toByteArray(), current.toHexArray());
    }

    @Test
    public void TestLongInit() {
        BitSet expected = new BitSet(4);
        Block current = new Block(10);

        expected.set(1);
        expected.set(3);

        Assert.assertArrayEquals(expected.toByteArray(), current.toHexArray());
    }
}
