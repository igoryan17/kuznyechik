package services;

import models.Block;
import models.Data;

/**
 * Created by Alexander on 24.02.2017.
 */
public class Encryption {
    public static Data encrypt(Block K1, Block K2, Data data) {
        for (int i = 1; i <= 9; ++i) {
            for (int j = 0; j < data.length(); ++j) {
                data.set(j, lsx(data.get(j),null));
            }
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
