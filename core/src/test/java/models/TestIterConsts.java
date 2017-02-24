package models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alexander on 24.02.2017.
 */
public class TestIterConsts {
    public static String[] constsFromWiki =
            {
                    "6ea276726c487ab85d27bd10dd849401",
                    "dc87ece4d890f4b3ba4eb92079cbeb02",
                    "b2259a96b4d88e0be7690430a44f7f03",
                    "7bcd1b0b73e32ba5b79cb140f2551504",
                    "156f6d791fab511deabb0c502fd18105",
                    "a74af7efab73df160dd208608b9efe06",
                    "c9e8819dc73ba5ae50f5b570561a6a07",
                    "f6593616e6055689adfba18027aa2a08"
            };

    @Test
    public void CheckC1() {
        Block c = new Block(constsFromWiki[0]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(1).toHexArray());
    }

    @Test
    public void CheckC2() {
        Block c = new Block(constsFromWiki[1]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(2).toHexArray());
    }

    @Test
    public void CheckC3() {
        Block c = new Block(constsFromWiki[2]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(3).toHexArray());
    }

    @Test
    public void CheckC4() {
        Block c = new Block(constsFromWiki[3]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(4).toHexArray());
    }

    @Test
    public void CheckC5() {
        Block c = new Block(constsFromWiki[4]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(5).toHexArray());
    }

    @Test
    public void CheckC6() {
        Block c = new Block(constsFromWiki[5]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(6).toHexArray());
    }

    @Test
    public void CheckC7() {
        Block c = new Block(constsFromWiki[6]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(7).toHexArray());
    }

    @Test
    public void CheckC8() {
        Block c = new Block(constsFromWiki[7]);

        Assert.assertArrayEquals(c.toHexArray(), IterConsts.get(8).toHexArray());
    }
}
