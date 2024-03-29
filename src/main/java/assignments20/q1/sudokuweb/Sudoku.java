package assignments20.q1.sudokuweb;

public class Sudoku {
    private String sudokuField[][];
    private String gameID;
    private String gameTitle;

    public Sudoku() {
        sudokuField = new String[9][9];
    }

    public String[][] getSudokuField() {
        return sudokuField;
    }

    public void setSudokuField(String[][] sudokuField) {
        this.sudokuField = sudokuField;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
}
