package test2.onetwotrip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// all memory
public class TxtReader {
    //    8 bytes for the object header

    private String word; // 8 * ( ( (n * 2) + 45) / 8) bytes; where n is count of chars
    private char[][] charArray; // about 32 + (32 + 4 * M) * N where M is count of row's and N is count of col's
    private List<Pair> list; // Pair = about 18 bytes (see class Pair fo details)
    // list size = (Object header (4 bytes) + one int (4 bytes) + one reference (4 bytes)) * n where n is count of chars from "word"

//    Class size  =  8 * ( ( (n * 2) + 45) / 8) + 32 + (32 + 4 * M) * N + 12 * n

    public TxtReader(String word, File file) {
        this.word = word;
        try {
            this.charArray = getCharArrayFromFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void showWord() {
        char[] chars = word.toCharArray();
        list = new ArrayList<>();

//        3 cycles give O(n^3) complexity

        for (char aChar : chars) {
            findChar(list, aChar);
        }
        for (Pair aList : list) {
            System.out.println(aList.toString());
        }
    }

    private void findChar(List<Pair> list, char letter) {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                if (letter == charArray[i][j] || letter == changeCase(charArray[i][j])) {
                    list.add(new Pair(i, j, charArray[i][j]));
                    charArray[i][j] = ' ';
                    return;
                }
            }
        }
        throw new RuntimeException("Impossible");
    }

    private char changeCase(char letter) {
        if (Character.isUpperCase(letter)) {
            return Character.toLowerCase(letter);
        }
        return Character.toUpperCase(letter);
    }

    private char[][] getCharArrayFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Col Count: " + colCount + "   Row Count: " + rowCount);

        char[][] chars = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            chars[i] = Arrays.copyOf(scanner.nextLine().toCharArray(), colCount);
        }
        return chars;
    }

}
