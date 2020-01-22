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

    public void fillSudoku() {

        for (int i = 0; i < sudokuField.length; i++) {
            for (int j = 0; j < sudokuField[i].length; j++) {

                sudokuField[i][j] = "4";

            }
        }

    }


    public void clear() {

        for (int i = 0; i < sudokuField.length; i++) {
            for (int j = 0; j < sudokuField[i].length; j++) {

                sudokuField[i][j] = " ";

            }
        }

    }
}
