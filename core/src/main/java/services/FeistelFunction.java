package services;

import models.Block;
import models.CartesianProductOfBlocks;

import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class FeistelFunction {
    public static CartesianProductOfBlocks execute(CartesianProductOfBlocks cartesianProductOfBlocks, Block key) {
        Block a1 = cartesianProductOfBlocks.getLeft();
        Block temp1 = new Block((BitSet) a1.getBits().clone());
        Block a0 = cartesianProductOfBlocks.getRight();
        a1.getBits().xor(key.getBits());
        byte[] bytesOfA1 = a1.toHexArray();
        Substitution.substitute(bytesOfA1);
        bytesOfA1 = Permutation.replace16Times(bytesOfA1);
        a1.update(bytesOfA1);
        a0.getBits().xor(a1.getBits());
        cartesianProductOfBlocks.setRight(temp1);
        cartesianProductOfBlocks.setLeft(a0);
        return cartesianProductOfBlocks;
    }
}
