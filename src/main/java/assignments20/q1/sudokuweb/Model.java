package assignments20.q1.sudokuweb;

public interface Model {

    boolean checkSudoku();

   boolean solveSudoku();

    void clear();

    String[][] getBoardValue();

   void setBoardValue(String[][] boardValue);
}
