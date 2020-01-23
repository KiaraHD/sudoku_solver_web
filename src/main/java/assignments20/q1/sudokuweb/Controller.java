package assignments20.q1.sudokuweb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Random;

@Named
@RequestScoped
public class Controller {

    ArrayList<Sudoku> sudokus = new ArrayList();

    String gameid;

    Model model = new Board();

    Boolean isCorrect;
    private String keyboard = "123,456,789";

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public ArrayList<Sudoku> getSudokus() {
        return sudokus;
    }

    public void setSudokus(ArrayList<Sudoku> sudokus) {
        this.sudokus = sudokus;
    }

    public void checkSudoku(Sudoku sudoku) {

        isCorrect = model.checkSudoku(sudoku);
    }

    public Sudoku solveSudoku(Sudoku sudoku) {

        return model.solveSudoku(sudoku);
    }

    public ArrayList generateList() {

        sudokus.clear();

        String[][] game1 = new String[][]{
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

        Sudoku tmp = new Sudoku();
        tmp.setGameID("0");
        tmp.setGameTitle("Game #000");
        tmp.setSudokuField(game1);

        sudokus.add(tmp);

        String[][] game = new String[][]{
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

        Sudoku tmp1 = new Sudoku();
        tmp1.setGameID("1");
        tmp1.setGameTitle("Game #001");
        tmp1.setSudokuField(game);

        sudokus.add(tmp1);

        String[][] game2 = new String[][]{
                {"", "", "7", "9", "", "2", "", "", ""},
                {"", "", "", "", "5", "", "", "", "2"},
                {"", "5", "", "", "4", "8", "3", "", "9"},
                {"2", "9", "1", "", "6", "", "", "", "4"},
                {"5", "", "3", "", "7", "", "9", "1", ""},
                {"7", "6", "", "8", "", "", "2", "3", ""},
                {"4", "", "", "5", "", "", "6", "", "7"},
                {"8", "", "5", "6", "2", "", "", "9", "3"},
                {"3", "2", "", "4", "9", "", "8", "5", ""}
        };

        Sudoku tmp2 = new Sudoku();
        tmp2.setGameID("2");
        tmp2.setGameTitle("Game #002");
        tmp2.setSudokuField(game2);

        sudokus.add(tmp2);

        return sudokus;
    }


    public Sudoku setSudoku(Sudoku sudoku, String gameID) {

        Sudoku tmp;

        if (gameID.equals("")) {

            Random rand = new Random();
            int randomNum = rand.nextInt(sudokus.size() + 1);

            tmp = sudokus.get(randomNum);

        } else {

            tmp = sudokus.get(Integer.parseInt(gameID));

        }

            sudoku.setSudokuField(tmp.getSudokuField());
        return sudoku;
    }
}