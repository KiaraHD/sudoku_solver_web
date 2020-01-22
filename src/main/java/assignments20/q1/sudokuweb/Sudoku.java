package assignments20.q1.sudokuweb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Sudoku {
    private String sudokuField[][] = new String[9][9];

    public String[][] getSudokuField() {
        return sudokuField;
    }

    public void setSudokuField(String[][] sudokuField) {
        this.sudokuField = sudokuField;
    }

    public void genrerateDefaultSudoku() {

        String[][] sudokuField2 = new String[][]{
                {"5", "3", "4", "", "7", "8", "", "1", "2"},
                {"", "7", "2", "1", "9", "5", "3", "4", ""},
                {"1", "9", "8", "", "4", "", "5", "", "7"},
                {"8", "", "9", "", "6", "1", "4", "", "3"},
                {"", "2", "6", "", "5", "3", "7", "9", "1"},
                {"7", "", "3", "9", "2", "", "8", "", "6"},
                {"9", "6", "1", "", "3", "", "2", "8", "4"},
                {"", "8", "7", "4", "", "9", "6", "", "5"},
                {"3", "4", "5", "", "8", "", "1", "7", "9"}
        };

        sudokuField = sudokuField2;
    }


    public void genrerateDefaultSudoku2() {

        String[][] sudokuField2 = new String[][]{
                {"", "7", "", "", "", "4", "1", "3", "0"},
                {"", "", "", "2", "", "7", "", "", "6"},
                {"", "", "5", "", "1", "3", "", "2", ""},
                {"", "", "1", "", "", "2", "", "", ""},
                {"", "", "2", "1", "9", "", "", "5", "7"},
                {"", "", "3", "", "4", "5", "8", "", "2"},
                {"", "1", "", "3", "7", "8", "2", "6", ""},
                {"3", "6", "7", "", "", "", "5", "8", ""},
                {"8", "", "9", "", "", "1", "", "7", ""}
        };

        sudokuField = sudokuField2;
    }


    public void clear() {

        for (int i = 0; i < sudokuField.length; i++) {
            for (int j = 0; j < sudokuField[i].length; j++) {

                sudokuField[i][j] = "";

            }
        }

    }
}
