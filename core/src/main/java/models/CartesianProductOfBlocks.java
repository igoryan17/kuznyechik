package models;

/**
 * Created by igoryan on 23.02.2017.
 */
public class CartesianProductOfBlocks {
    private Block left;
    private Block right;

    public CartesianProductOfBlocks(Block left, Block right) {
        this.left = left;
        this.right = right;
    }

    public Block getLeft() {
        return left;
    }

    public void setLeft(Block left) {
        this.left = left;
    }

    public Block getRight() {
        return right;
    }

    public void setRight(Block right) {
        this.right = right;
    }
}
