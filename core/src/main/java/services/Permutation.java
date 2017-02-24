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
        result[15] = linearTransformationResult;
        for (int i = 0; i < result.length - 1; ++i) {
            result[i] = blocks[i + 1];
        }
        return result;
    }

    public static byte[] revertReplacing(byte[] blocks) {
        Block.checkSize(blocks);
        byte linearTransformationResult = LinearTransformation.transform(
                blocks[15], blocks[0], blocks[1], blocks[2],
                blocks[3], blocks[4], blocks[5], blocks[6],
                blocks[7], blocks[8], blocks[9], blocks[10],
                blocks[11], blocks[12], blocks[13], blocks[14]
        );
        byte[] result = new byte[Constants.COUNT_OF_HEX_BLOCKS];
        for (int i = result.length - 1; i > 0; --i) {
            result[i] = blocks[i - 1];
        }
        result[0] = linearTransformationResult;
        return result;
    }

    public static byte[] replace16Times(byte[] blocks) {
        for (int i = 0; i < 16; ++i) {
            blocks = replace(blocks);
        }

        return blocks;
    }

    public static void revertReplacing16Times(byte[] blocks) {
        for (int i = 0; i < 16; ++i) {
            blocks = revertReplacing(blocks);
        }
    }
}
