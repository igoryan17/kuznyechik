package models;

/**
 * Created by igoryan on 23.02.2017.
 */
public class CartesianProductOfBlocks {
    private Block a1;
    private Block a0;

    public CartesianProductOfBlocks(Block a1, Block a0) {
        this.a1 = a1;
        this.a0 = a0;
    }

    public Block getA1() {
        return a1;
    }

    public void setA1(Block a1) {
        this.a1 = a1;
    }

    public Block getA0() {
        return a0;
    }

    public void setA0(Block a0) {
        this.a0 = a0;
    }
}
