package services;

import models.Block;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alexander on 24.02.2017.
 */
public class TestKeys {

    // Doesn't work: unknown reason
    private String k1_str = "8899aabbccddeeff0011223344556677";
    private String k2_str = "fedcba98765432100123456789abcdef";
    private String k3_exp = "db31485315694343228d6aef8cc78c44";
    private String k10_exp = "72e9dd7416bcf45b755dbaa88e4a4043";

    @Test
    public void TestK10() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K10_exp = new Block(k10_exp);
        Block K10_curr = keys.get(10);

        Assert.assertArrayEquals(K10_exp.toHexArray(), K10_curr.toHexArray());
    }

    @Test
    public void TestK3() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K3_exp = new Block(k3_exp);
        Block K3_curr = keys.get(3);

        Assert.assertArrayEquals(K3_exp.toHexArray(), K3_curr.toHexArray());
    }
}
