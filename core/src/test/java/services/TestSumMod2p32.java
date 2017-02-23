package services;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by Alexander on 23.02.2017.
 */
public class TestSumMod2p32 {
    @Test
    public void SumAllTruePlusOne() {
        BitSet first = new BitSet(32);
        BitSet full_null = new BitSet(32);

        for (int i = 0; i < 32; ++i) {
            first.set(i);
            full_null.set(i, false);
        }

        BitSet second = new BitSet(32);
        second.set(0);

        Assert.assertEquals(full_null, SumMod2p32.sum(first, second));
    }
}
