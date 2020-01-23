package assignments20.q1.sudokuweb;

public interface Model {

    boolean checkSudoku(Sudoku sudoku);

    Sudoku solveSudoku(Sudoku sudoku);

    void clear();
}
