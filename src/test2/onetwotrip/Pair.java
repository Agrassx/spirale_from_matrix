package test2.onetwotrip;

public class Pair {

    private int row;
    private int col;
    private char letter;

    public Pair(int row, int col, char letter) {
        this.col = col;
        this.row = row;
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return String.format("%s - (%s;%s)", letter, row, col);
    }
}
