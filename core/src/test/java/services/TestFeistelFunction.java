package services;

import models.Block;
import models.CartesianProductOfBlocks;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by igoryan on 24.02.2017.
 */
public class TestFeistelFunction {
    @Test
    public void testFeistelFunctionValues() {
        Block c1 = new Block("6ea276726c487ab85d27bd10dd849401");
        Block k1 = new Block("8899aabbccddeeff0011223344556677");
        Block k2 = new Block("fedcba98765432100123456789abcdef");
        Block expectedLeft = new Block("c3d5fa01ebe36f7a9374427ad7ca8949");
        Block expectedRight = new Block("8899aabbccddeeff0011223344556677");
        CartesianProductOfBlocks argument = new CartesianProductOfBlocks(k1, k2);
        FeistelFunction.execute(argument, c1);
        Assert.assertEquals(expectedLeft.getBits(), argument.getLeft().getBits());
        Assert.assertEquals(expectedRight.getBits(), argument.getRight().getBits());
    }
}
