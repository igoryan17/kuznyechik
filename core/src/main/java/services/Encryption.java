package services;

import models.Block;
import models.Data;

/**
 * Created by Alexander on 24.02.2017.
 */
public class Encryption {
    public static Data encrypt(Block K1, Block K2, Data data) {
        Block prevLeft = K1;
        Block prevRight = K2;

        for (int i = 1; i <= 5; ++i) {
            Block left = Keys.GetKey(prevLeft, prevRight, 2 * i - 1);
            Block right = Keys.GetKey(prevLeft, prevRight, 2 * i);

            for (int j = 0; j < data.length(); ++j) {
                data.set(j, lsx(data.get(j), left));
                if (i != 5) {
                    data.set(j, lsx(data.get(j), right));
                }
                else {
                    data.get(j).getBits().xor(right.getBits()); // X
                }
            }

            prevLeft = left;
            prevRight = right;
        }

        return data;
    }

    public static Block lsx(Block input, Block k) {
        input.getBits().xor(k.getBits()); // X

        byte[] temp = input.toHexArray();
        Substitution.substitute(temp); // S

        temp = Permutation.replace16Times(temp); // L
        input.update(temp);

        return input;
    }
}
