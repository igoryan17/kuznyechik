package models;

import services.Permutation;

/**
 * Created by Alexander on 23.02.2017.
 */
public class IterConsts {
    private static final Block[] consts = new Block[32];

    static {
        for (int i = 0; i < 32; ++i) {
            consts[i] = new Block(i + 1);
            byte[] arr = consts[i].toHexArray();
            Permutation.replace16Times(arr);
            consts[i].update(arr);
        }
    }

    public static Block get(int i) {
        return consts[i - 1];
    }
}
