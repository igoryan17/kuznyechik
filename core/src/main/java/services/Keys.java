package services;

import models.Block;
import models.CartesianProductOfBlocks;
import models.IterConsts;

import java.util.BitSet;

/**
 * Created by Alexander on 23.02.2017.
 */
public class Keys {
    private static Block[] keys = new Block[10];

    public Keys(Block k1, Block k2) {
        keys[0] = new Block((BitSet) k1.getBits().clone());
        keys[1] = new Block((BitSet) k2.getBits().clone());

        for (int i = 0; i <= 3; ++i) {
            Block temp0 = new Block((BitSet) keys[2 * i].getBits().clone());
            Block temp1 = new Block((BitSet) keys[2 * i + 1].getBits().clone());

            CartesianProductOfBlocks prod = new CartesianProductOfBlocks(temp0, temp1);

            for (int j = 1; j <= 8; ++j) {
                prod = FeistelFunction.execute(prod, IterConsts.get(8 * i + j));
            }

            keys[2 * i + 2] = prod.getLeft();
            keys[2 * i + 3] = prod.getRight();
        }
    }

    public Block get(int i) {
        return keys[i - 1];
    }
}
