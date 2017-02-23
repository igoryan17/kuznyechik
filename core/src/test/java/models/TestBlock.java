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
        BitSet exp = new BitSet(4);
        Block current = new Block("a");

        exp.set(1);
        exp.set(3);

        Block expected = new Block(exp);

        Assert.assertArrayEquals(expected.toHexArray(), current.toHexArray());
    }

    @Test
    public void TestLongInit() {
        BitSet exp = new BitSet(4);
        Block current = new Block(10);

        exp.set(1);
        exp.set(3);

        Block expected = new Block(exp);

        Assert.assertArrayEquals(expected.toHexArray(), current.toHexArray());
    }
}
