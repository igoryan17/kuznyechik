package services;

import models.Block;
import models.Constants;

import java.util.BitSet;

/**
 * Created by igoryan on 22.02.2017.
 */
public class Permutation {
    public static Block replace(byte[] blocks) {
        Block.checkSize(blocks);
        byte linearTransformationResult = LinearTransformation.transform(blocks);
        byte[] result = new byte[Constants.COUNT_OF_HEX_BLOCKS];
        result[0] = linearTransformationResult;
        for (int i = 1; i < result.length; ++i) {
            result[i] = blocks[i - 1];
        }
        return new Block(BitSet.valueOf(result));
    }
}
