package services;

import models.Block;
import models.CartesianProductOfBlocks;

/**
 * Created by igoryan on 23.02.2017.
 */
public class FeistelFunction {
    public static void execute(CartesianProductOfBlocks cartesianProductOfBlocks, Block key) {
        Block a1 = cartesianProductOfBlocks.getA1();
        Block a0 = cartesianProductOfBlocks.getA0();
        a1.getBits().xor(key.getBits());
        byte[] bytesOfA1 = a1.toHexArray();
        Substitution.substitute(bytesOfA1);
        Permutation.replace16Times(bytesOfA1);
        a1.update(bytesOfA1);
        a0.getBits().xor(a1.getBits());
        cartesianProductOfBlocks.setA0(a1);
        cartesianProductOfBlocks.setA1(a0);
    }
}
