package services;

import models.Block;

import java.util.BitSet;
import java.util.List;

/**
 * Created by Alexander on 24.02.2017.
 */
public class Decryption {
    public static List<Block> decrypt(Block K1, Block K2, List<Block> data) {
        Block[] keys = new Block[10];
        keys[0] = new Block((BitSet) K1.getBits().clone());
        keys[1] = new Block((BitSet) K2.getBits().clone());

        for (int i = 2; i <= 5; ++i) {
            keys[2 * i - 2] = Keys.GetKey(keys[2 * i - 4], keys[2 * i - 3], 2 * i - 1);
            keys[2 * i - 1] = Keys.GetKey(keys[2 * i - 4], keys[2 * i - 3], 2 * i);
        }

        for (int i = 9; i >= 0; --i) {
            for (int j = 0; j < data.size(); j++) {
                if (i != 0) {
                    data.set(j, srlrx(data.get(j), keys[i]));
                }
                else {
                    data.get(j).getBits().xor(keys[i].getBits());
                }
            }
        }

        return data;
    }

    public static Block srlrx(Block input, Block k) {
        input.getBits().xor(k.getBits()); // X

        byte[] temp = input.toHexArray();
        temp = Permutation.revertReplacing16Times(temp); //Lr

        Substitution.revertSubstitution(temp); // Sr
        input.update(temp);

        return input;
    }
}
