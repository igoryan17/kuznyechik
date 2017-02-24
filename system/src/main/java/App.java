import models.Block;
import services.Decryption;
import services.Encryption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igoryan on 24.02.2017.
 */
public class App {
    public static void main(String[] args) {
        String hexInput = "b66cd8887d38e8d77765aeea0c9a7efc";
        Block inputBlock = new Block(hexInput);
        List<Block> inputs = new ArrayList<>(1);
        inputs.add(inputBlock);
        Block K1 = new Block("8899aabbccddeeff0011223344556677");
        Block K2 = new Block("fedcba98765432100123456789abcdef");
        List<Block> encrypted = Encryption.encrypt(K1, K2, inputs);
        System.out.println(encrypted.iterator().next());
        List<Block> decryption = Decryption.decrypt(K1, K2, encrypted);
        System.out.println(decryption.iterator().next());
    }
}
