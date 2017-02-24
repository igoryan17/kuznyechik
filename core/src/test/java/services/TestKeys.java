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
    private String k4_exp = "3d4553d8e9cfec6815ebadc40a9ffd04";
    private String k5_exp = "57646468c44a5e28d3e59246f429f1ac";
    private String k6_exp = "bd079435165c6432b532e82834da581b";
    private String k7_exp = "51e640757e8745de705727265a0098b1";
    private String k8_exp = "5a7925017b9fdd3ed72a91a22286f984";
    private String k9_exp = "bb44e25378c73123a5f32f73cdb6e517";
    private String k10_exp = "72e9dd7416bcf45b755dbaa88e4a4043";

    @Test
    public void TestK3() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K3_exp = new Block(k3_exp);
        Block K3_curr = keys.get(3);

        Assert.assertArrayEquals(K3_exp.toHexArray(), K3_curr.toHexArray());
    }

    @Test
    public void TestK4() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K4_exp = new Block(k4_exp);
        Block K4_curr = keys.get(4);

        Assert.assertArrayEquals(K4_exp.toHexArray(), K4_curr.toHexArray());
    }

    @Test
    public void TestK5() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K5_exp = new Block(k5_exp);
        Block K5_curr = keys.get(5);

        Assert.assertArrayEquals(K5_exp.toHexArray(), K5_curr.toHexArray());
    }

    @Test
    public void TestK6() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K6_exp = new Block(k6_exp);
        Block K6_curr = keys.get(6);

        Assert.assertArrayEquals(K6_exp.toHexArray(), K6_curr.toHexArray());
    }

    @Test
    public void TestK7() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K7_exp = new Block(k7_exp);
        Block K7_curr = keys.get(7);

        Assert.assertArrayEquals(K7_exp.toHexArray(), K7_curr.toHexArray());
    }

    @Test
    public void TestK8() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K8_exp = new Block(k8_exp);
        Block K8_curr = keys.get(8);

        Assert.assertArrayEquals(K8_exp.toHexArray(), K8_curr.toHexArray());
    }

    @Test
    public void TestK9() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K9_exp = new Block(k9_exp);
        Block K9_curr = keys.get(9);

        Assert.assertArrayEquals(K9_exp.toHexArray(), K9_curr.toHexArray());
    }

    @Test
    public void TestK10() {
        Keys keys = new Keys(new Block(k1_str), new Block(k2_str));

        Block K10_exp = new Block(k10_exp);
        Block K10_curr = keys.get(10);

        Assert.assertArrayEquals(K10_exp.toHexArray(), K10_curr.toHexArray());
    }
}
