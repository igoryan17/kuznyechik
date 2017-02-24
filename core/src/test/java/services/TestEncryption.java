package services;

import models.Block;
import models.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alexander on 24.02.2017.
 */
public class TestEncryption {

    @Test
    public void TestFromGost() {
        Data data = new Data(new Block("1122334455667700ffeeddccbbaa9988"));
        Block k1 = new Block("8899aabbccddeeff0011223344556677");
        Block k2 = new Block("fedcba98765432100123456789abcdef");
        Block exp = new Block("7f679d90bebc24305a468d42b9d4edcd");

        data = Encryption.encrypt(k1, k2, data);
        Assert.assertArrayEquals(exp.toHexArray(), data.get(0).toHexArray());
    }

    @Test
    public void TestLSX() {
        Block k1 = new Block("8899aabbccddeeff0011223344556677");
        Block a = new Block("1122334455667700ffeeddccbbaa9988");

        Block exp = new Block("e297b686e355b0a1cf4a2f9249140830");

        a = Encryption.lsx(a, k1);
        Assert.assertArrayEquals(exp.toHexArray(), a.toHexArray());
    }
}
