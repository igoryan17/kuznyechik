package models;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by igoryan on 23.02.2017.
 */
public class TestGaloisField {
    @Test
    public void testAddPolynomials() {
        BitSet element = new BitSet(9);
        element.set(5);
        element.set(4);
        element.set(3);
        element.set(2);
        GaloisField galoisField = new GaloisField(element);
        galoisField.add(new GaloisField(GaloisField.GENERIC_POLYNOMIAL));
        System.out.println(galoisField);
        for (int i = 0; i < element.length(); ++i) {
            boolean bit = element.get(i);
            Assert.assertTrue("element " + i + " is " + bit, bit);
        }
    }

    @Test
    public void testDiv() {
        BitSet element = new BitSet(10);
        // x^9 + x^8 + x^7 + x^2 + x + 1
        element.set(9);
        element.set(8);
        element.set(7);
        element.set(2);
        element.set(1);
        element.set(0);
        GaloisField galoisField = new GaloisField(element);
        galoisField.div();
        element = galoisField.getCoefficients();
        System.out.println(galoisField);
        Assert.assertEquals(0, element.nextSetBit(0));
    }

    @Test
    public void testFindFirstSetBit() {
        BitSet bits = new BitSet(5);
        bits.set(4);
        Assert.assertEquals(4, GaloisField.findFirstSetHighBit(bits));
    }

    @Test
    public void testSimpleMultiple() {
        BitSet first = new BitSet(1);
        // 1
        first.set(0);
        GaloisField firstPolynomial = new GaloisField(first);
        BitSet second = new BitSet(2);
        // x + 1
        second.set(1);
        second.set(0);
        GaloisField secondPolynomial = new GaloisField(second);
        // x + 1
        BitSet result = new BitSet(2);
        result.set(1);
        result.set(0);
        GaloisField expected = new GaloisField(result);
        GaloisField actual = GaloisField.multiple(firstPolynomial, secondPolynomial);
        GaloisField sameWithActual = GaloisField.multiple(secondPolynomial, firstPolynomial);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(actual, sameWithActual);
    }

    @Test
    public void testMiddleMultiple() {
        BitSet first = new BitSet(3);
        //x^2 + x +1
        first.set(2);
        first.set(1);
        first.set(0);
        GaloisField firstPolynomial = new GaloisField(first);
        BitSet second = new BitSet(2);
        //x + 1
        second.set(1);
        second.set(0);
        GaloisField secondPolynomial = new GaloisField(second);
        BitSet result = new BitSet(4);
        //x^3 + 1
        result.set(3);
        result.set(0);
        GaloisField expected = new GaloisField(result);
        GaloisField actual = GaloisField.multiple(firstPolynomial, secondPolynomial);
        Assert.assertEquals(expected, actual);
    }
}
