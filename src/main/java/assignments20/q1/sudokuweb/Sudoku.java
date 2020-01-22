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



}
