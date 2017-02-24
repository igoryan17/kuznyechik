package models;

/**
 * Created by Alexander on 24.02.2017.
 */
public class Data {

    private Block[] data;

    public Data(Block... input) {
        data = new Block[input.length];

        for (int i = 0; i < data.length; ++i) {
            data[i] = new Block(input[i].getBits());
        }
    }

    public Block get(int index) {
        return data[index];
    }

    public void set(int index, Block block) {
        data[index] = new Block(block.getBits());
    }

    public int length() {
        return data.length;
    }
}
