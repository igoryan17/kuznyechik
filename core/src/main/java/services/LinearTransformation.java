package services;

import models.Block;
import models.GaloisField;

import java.util.*;

/**
 * Created by igoryan on 23.02.2017.
 */
public class LinearTransformation {
    /*ℓ(a15, …, a0) = ∇(148 ∙ ∆(a15) + 32 ∙ ∆(a14) + 133 ∙ ∆(a13) + 16 ∙ ∆(a12) +
    194 ∙ ∆(a11) + 192 ∙ ∆(a10) + 1 ∙ ∆(a9) + 251 ∙ ∆(a8) + 1 ∙ ∆(a7) + 192 ∙ ∆(a6) +
    194 ∙ ∆(a5) + 16 ∙ ∆(a4) + 133 ∙ ∆(a3) + 32 ∙ ∆(a2) + 148 ∙ ∆(a1) + 1 ∙ ∆(a0))*/

    public static final List<GaloisField> coefficients = Arrays.asList(
            new GaloisField(148),
            new GaloisField(32),
            new GaloisField(133),
            new GaloisField(16),
            new GaloisField(194),
            new GaloisField(192),
            new GaloisField(1),
            new GaloisField(251),
            new GaloisField(1),
            new GaloisField(192),
            new GaloisField(194),
            new GaloisField(16),
            new GaloisField(133),
            new GaloisField(32),
            new GaloisField(148),
            new GaloisField(1));

    public static byte transform(byte... input) {
        Block.checkSize(input);
        List<GaloisField> galoisFields = new ArrayList<>(input.length);
        for (int i = 0; i < input.length; ++i) {
            GaloisField polynomial = new GaloisField(Byte.toUnsignedInt(input[i]));
            GaloisField multipleWithCoefficient = GaloisField.multiple(polynomial, coefficients.get( coefficients.size() - i - 1));
            galoisFields.add(multipleWithCoefficient);
        }
        Iterator<GaloisField> galoisPolynomialsIterator = galoisFields.iterator();
        GaloisField firstPolynomial = galoisPolynomialsIterator.next();
        while (galoisPolynomialsIterator.hasNext()) {
            firstPolynomial.add(galoisPolynomialsIterator.next());
        }
        BitSet coefficients = firstPolynomial.getCoefficients();

        if (coefficients.toByteArray().length == 0)
            return 0;

        return coefficients.toByteArray()[0];
    }
}
