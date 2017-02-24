package models;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by Alexander on 24.02.2017.
 */
public class TestBlock {

    // Doesn't work: input hex is too short
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

    @Test
    public void TestLongInit2() {
        Block curr = new Block(1);
        byte expected = 1;

        byte current = curr.toHexArray()[0];

        Assert.assertEquals(expected, current);
    }

    @Test
    public void testToString() {
        String hexString = "b66cd8887d38e8d77765aeea0c9a7efc";
        Block block = new Block(hexString);
        String actualRepresentation = block.toString();
        Assert.assertEquals(hexString, actualRepresentation.toLowerCase());
    }
}
