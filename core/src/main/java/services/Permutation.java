package services;

import models.Block;
import models.Constants;

/**
 * Created by igoryan on 22.02.2017.
 */
public class Permutation {
    public static byte[] replace(byte[] blocks) {
        Block.checkSize(blocks);
        byte linearTransformationResult = LinearTransformation.transform(blocks);
        byte[] result = new byte[Constants.COUNT_OF_HEX_BLOCKS];
        result[0] = linearTransformationResult;
        for (int i = 1; i < result.length; ++i) {
            result[i] = blocks[i - 1];
        }
        return result;
    }

    public static byte[] revertReplacing(byte[] blocks) {
        Block.checkSize(blocks);
        byte linearTransformationResult = LinearTransformation.transform(
                blocks[14], blocks[13], blocks[12], blocks[11],
                blocks[10], blocks[9], blocks[8], blocks[7],
                blocks[6], blocks[5], blocks[4], blocks[3],
                blocks[2], blocks[1], blocks[0], blocks[15]
        );
        byte[] result = new byte[Constants.COUNT_OF_HEX_BLOCKS];
        for (int i = 0; i < result.length - 1; ++i) {
            result[i] = blocks[blocks.length - 2 - i];
        }
        result[result.length - 1] = linearTransformationResult;
        return result;
    }

    public static void replace16Times(byte[] blocks) {
        for (int i = 0; i < 16; ++i) {
            blocks = replace(blocks);
        }
    }

    public static void revertReplacing16Times(byte[] blocks) {
        for (int i = 0; i < 16; ++i) {
            blocks = revertReplacing(blocks);
        }
    }
}
