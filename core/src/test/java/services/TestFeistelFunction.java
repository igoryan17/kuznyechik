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
    public void testFeistelFunctionOneTimeExecution() {
        testFeistelFunction(
                1,
                new Block("c3d5fa01ebe36f7a9374427ad7ca8949"),
                new Block("8899aabbccddeeff0011223344556677")
                );
    }

    @Test
    public void testFeistelFunctionTwoTimesExecution() {
        testFeistelFunction(
                2,
                new Block("37777748e56453377d5e262d90903f87"),
                new Block("c3d5fa01ebe36f7a9374427ad7ca8949")
        );
    }

    @Test
    public void testFeistelFunctionThreeTimesExecution() {
        testFeistelFunction(
                3,
                new Block("f9eae5f29b2815e31f11ac5d9c29fb01"),
                new Block("37777748e56453377d5e262d90903f87")
        );
    }

    @Test
    public void testFeistelFunctionFourTimesExecution() {
        testFeistelFunction(
                4,
                new Block("e980089683d00d4be37dd3434699b98f"),
                new Block("f9eae5f29b2815e31f11ac5d9c29fb01")
        );
    }

    @Test
    public void testFeistelFunctionFiveTimesExecution() {
        testFeistelFunction(
                5,
                new Block("b7bd70acea4460714f4ebe13835cf004"),
                new Block("e980089683d00d4be37dd3434699b98f")
        );
    }

    @Test
    public void testFeistelFunctionSixTimesExecution() {
        testFeistelFunction(
                6,
                new Block("1a46ea1cf6ccd236467287df93fdf974"),
                new Block("b7bd70acea4460714f4ebe13835cf004")
        );
    }

    public void testFeistelFunction(int iterations, Block expectedLeft, Block expectedRight) {
        Block[] constants = new Block[] {
                new Block("6ea276726c487ab85d27bd10dd849401"), // c1
                new Block("dc87ece4d890f4b3ba4eb92079cbeb02"), // c2
                new Block("b2259a96b4d88e0be7690430a44f7f03"), // c3
                new Block("7bcd1b0b73e32ba5b79cb140f2551504"), // c4
                new Block("156f6d791fab511deabb0c502fd18105"), // c5
                new Block("a74af7efab73df160dd208608b9efe06"), // c6
                new Block("c9e8819dc73ba5ae50f5b570561a6a07"), // c7
                new Block("f6593616e6055689adfba18027aa2a08"), // c8
        };
        Block[] keys = new Block[] {
                new Block("8899aabbccddeeff0011223344556677"), // k1
                new Block("fedcba98765432100123456789abcdef"), // k2
                new Block("db31485315694343228d6aef8cc78c44"), // k3
                new Block("3d4553d8e9cfec6815ebadc40a9ffd04"), // k4
                new Block("57646468c44a5e28d3e59246f429f1ac"), // k5
                new Block("bd079435165c6432b532e82834da581b"), // k6
                new Block("51e640757e8745de705727265a0098b1"), // k7
                new Block("5a7925017b9fdd3ed72a91a22286f984"), // k8
                new Block("bb44e25378c73123a5f32f73cdb6e517"), // k9
                new Block("72e9dd7416bcf45b755dbaa88e4a4043"), // k10
        };
        CartesianProductOfBlocks argument = new CartesianProductOfBlocks(keys[0], keys[1]);
        for (int i = 0; i < iterations; ++i) {
            FeistelFunction.execute(argument, constants[i]);
        }
        Assert.assertEquals(expectedLeft.getBits(), argument.getLeft().getBits());
        Assert.assertEquals(expectedRight.getBits(), argument.getRight().getBits());
    }
}
