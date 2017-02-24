package services;

import models.Block;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 24.02.2017.
 */
public class TestDecryption {

    @Test
    public void TestFromGost() {
        List<Block> data = new ArrayList<>();
        data.add(new Block("7f679d90bebc24305a468d42b9d4edcd"));
        Block k1 = new Block("8899aabbccddeeff0011223344556677");
        Block k2 = new Block("fedcba98765432100123456789abcdef");
        Block exp = new Block("1122334455667700ffeeddccbbaa9988");

        data = Decryption.decrypt(k1, k2, data);
        Assert.assertArrayEquals(exp.toHexArray(), data.get(0).toHexArray());
    }
}
