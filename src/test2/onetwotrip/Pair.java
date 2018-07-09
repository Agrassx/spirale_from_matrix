package test2.onetwotrip;

public class Pair {

//    8 bytes for the object header

    private int row; // 4 bytes
    private int col; // 4 bytes
    private char letter; // 2 bytes

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
