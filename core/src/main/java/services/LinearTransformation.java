package services;

import models.GaloisField;

import java.util.*;

/**
 * Created by igoryan on 23.02.2017.
 */
public class LinearTransformation {
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

    public BitSet transform(short[] input) {
        List<GaloisField> galoisFields = new ArrayList<GaloisField>(input.length);
        for (int i = 0; i < input.length; ++i) {
            GaloisField polynomial = new GaloisField(input[i]);
            galoisFields.add(GaloisField.multiple(polynomial, coefficients.get(i)));
        }
        Iterator<GaloisField> galoisPolynomialsIterator = galoisFields.iterator();
        GaloisField firstPolynomial = galoisPolynomialsIterator.next();
        while (galoisPolynomialsIterator.hasNext()) {
            firstPolynomial.add(galoisPolynomialsIterator.next());
        }
        return firstPolynomial.getCoefficients();
    }
}
