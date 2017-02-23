package models;

import java.nio.ByteBuffer;
import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class GaloisField {
    public static final BitSet GENERIC_POLYNOMIAL = new BitSet(Constants.SIZE_OF_POLYNOMIAL + 1);
    static {
        // x^8 + x^7 + x^6 + x + 1
        GENERIC_POLYNOMIAL.set(8);
        GENERIC_POLYNOMIAL.set(7);
        GENERIC_POLYNOMIAL.set(6);
        GENERIC_POLYNOMIAL.set(1);
        GENERIC_POLYNOMIAL.set(0);
    }
    private BitSet coefficients;

    public GaloisField(BitSet coefficients) {
        this.coefficients = coefficients;
    }

    public GaloisField(long number) {
        coefficients = BitSet.valueOf(new long[] {number});
    }

    public void add(GaloisField another) {
        coefficients.xor(another.getCoefficients());
    }

    public void div() {
        if (coefficients.length() > GENERIC_POLYNOMIAL.length()) {
            int firstHighBit = coefficients.length();
            int lastHighBit = coefficients.length() - GENERIC_POLYNOMIAL.length();
            BitSet firstBits = coefficients.get(lastHighBit, firstHighBit);
            firstBits.xor(GENERIC_POLYNOMIAL);
            int firstTrueBit = findFirstSetHighBit(firstBits);
            coefficients = coefficients.get(0, lastHighBit);
            if (firstTrueBit >= 0) {
                firstBits = firstBits.get(lastHighBit, firstTrueBit + 1);
                ByteBuffer byteBuffer = ByteBuffer.wrap(firstBits.toByteArray());
                byteBuffer.put(coefficients.toByteArray());
                coefficients = BitSet.valueOf(byteBuffer);
            }
            div();
        }
    }

    public static void clearFirstsFalseHighBits(BitSet bitSet) {
        int firstSettedHighBit = findFirstSetHighBit(bitSet);
        if (firstSettedHighBit >= 0) {
            bitSet = bitSet.get(0, firstSettedHighBit + 1);
        }
    }

    public static BitSet multiplePolynomialsCoefficients(BitSet first, BitSet second) {
        int resultLength = first.length() + second.length();
        BitSet result = new BitSet(resultLength);
        for (int i = 0; i < first.length(); ++i) {
            for (int j = 0; j < second.length(); ++j) {
                result.set(i + j, result.get(i + j) ^ first.get(i) && second.get(j));
            }
        }
        return result;
    }

    public static GaloisField multiple(GaloisField first, GaloisField second) {
        return new GaloisField(multiplePolynomialsCoefficients(first.coefficients, second.coefficients));
    }

    public static int findFirstSetHighBit(BitSet bits) {
        int i = bits.nextSetBit(0);
        int j;
        while (i >= 0 && i < bits.length() - 1) {
            j = bits.nextSetBit(i + 1);
            if (j < 0) {
                return i;
            } else {
                i = j;
            }
        }
        return i;
    }

    public BitSet getCoefficients() {
        return coefficients;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = coefficients.length() - 1; i >= 0; --i) {
            if (coefficients.get(i)) {
                if (i < coefficients.length() - 1) {
                    stringBuffer.append(" + ");
                }
                if (i > 0) {
                    stringBuffer.append("x^" + i);
                } else {
                    stringBuffer.append("1");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GaloisField) {
            return coefficients.equals(((GaloisField) obj).coefficients);
        }
        return false;
    }
}
