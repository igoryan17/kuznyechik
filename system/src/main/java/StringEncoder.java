import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import models.Block;
import models.Constants;
import org.apache.commons.codec.binary.Hex;

/**
 * Created by igoryan on 24.02.2017.
 */
public class StringEncoder {
    public static Block[] encodeStringToHex(String data) {
        if (Strings.isNullOrEmpty(data)) {
            throw new IllegalArgumentException("data must be filled");
        }
        String hexString = Hex.encodeHexString(data.getBytes());
        String[] tokens = Iterables.toArray(
                Splitter.fixedLength(Constants.SIZE_OF_INPUT_HEX_BLOCK).split(hexString),
                String.class
        );
        return FluentIterable.from(tokens).transform(s -> {
            if (s.length() != Constants.SIZE_OF_INPUT_HEX_BLOCK) {
                s = s.concat(Strings.repeat("0", Constants.SIZE_OF_INPUT_HEX_BLOCK - s.length()));
                return new Block(s);
            } else {
                return new Block(s);
            }
        }).toArray(Block.class);
    }

    public static String[] decode(Block[] blocks) {
        return FluentIterable.from(blocks).transform(block -> new String(block.getBits().toByteArray())).toArray(String.class);
    }
}
