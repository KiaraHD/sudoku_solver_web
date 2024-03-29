package assignments20.q1.sudokuweb;

import libs.inout.In;
import libs.inout.Out;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ViewScoped
public class Controller implements Serializable {

    static String FILE_NAME = "/home/kiara/work/itl/src/main/java/assignments20/q1/sudokuweb/SudokuGames.csv";
    private List<Sudoku> sudokuCollection;
    private Sudoku sudoku;
    private String gameid;
    private String gameTitle;
    private Board model;
    private Boolean isCorrect;
    private boolean gameChosen;
    private String keyboard;
    private int difficulty;


    public Controller() {

        sudokuCollection = new ArrayList();
        model = new Board();
        keyboard = "123,456,789";
        gameChosen = false;
        difficulty = 1;

//        File file = new File("main/java/assignments20/q1/sudokuweb/SudokuGames.csv");
//        String path = file.getAbsolutePath();
//        System.out.println(path);
//        FILE_NAME = path;

    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isGameChosen() {
        return gameChosen;
    }

    public void setGameChosen(boolean gameChosen) {
        this.gameChosen = gameChosen;
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public Board getModel() {
        return model;
    }

    public void setModel(Board model) {
        this.model = model;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
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

    public void checkSudoku() {

        resetValues();
        isCorrect = model.checkSudoku();
    }


    public void solveSudoku() {

        resetValues();
        isCorrect = model.solveSudoku();
    }

    public List<Sudoku> getSudokuCollection() {
        return sudokuCollection;
    }

    public void setSudokuCollection(List<Sudoku> sudokuCollection) {
        this.sudokuCollection = sudokuCollection;
    }

    public List generateList() {

        sudokuCollection.clear();

        saveSudokuFromFile();

        return sudokuCollection;
    }

    public void setSudokuField() {

        gameChosen = true;
        Sudoku tmp;

        if (gameid.equals("")) {
            return;
        }

        if (gameid.equals("random")) {


            Random rand = new Random();
            int randomNum = rand.nextInt(sudokuCollection.size());

            tmp = sudokuCollection.get(randomNum);

        } else {

            tmp = sudokuCollection.get(Integer.parseInt(gameid));
        }

        Out.println("--> sudoku " + tmp.getGameTitle() + " with difficultly " + difficulty + " generated");

        gameTitle = " - " + tmp.getGameTitle();
        model.setBoardValue(tmp.getSudokuField());
        sudoku = tmp;
    }

    public void saveSudokuFromFile() {

        //what the txd file should look like: 5,3,4,,7,8,,1,2,,7,2,1,9,5,3,4,,1,9,8,,4,,5,,7,8,,9,,6,1,4,,3,,2,6,,5,3,7,9,1,7,,3,9,2,,8,,6,9,6,1,,3,,2,8,4,,8,7,4,,9,6,,5,3,4,5,,8,,1,7,9,001,Game #000
        //81 Zeichen field (durch komma gestrennt) -> 3 Zeichen ID  -> restliche Zeichen Name (9 Zeichen)

        In.open(FILE_NAME);

        while (In.done() && In.peek() != In.eof) {

            String sudokuString = In.readLine();
            String sudokuArray[] = sudokuString.split(",");

            Sudoku tmp = new Sudoku();
            String[][] sudokuFieldTmp = new String[9][9];


            int count = 0;
            for (int i = 0; i < tmp.getSudokuField().length; i++) {
                for (int j = 0; j < tmp.getSudokuField()[i].length; j++) {

                    sudokuFieldTmp[i][j] = sudokuArray[count];

                    count++;

                }
            }
            tmp.setSudokuField(sudokuFieldTmp);
            tmp.setGameTitle(sudokuArray[82]);
            tmp.setGameID(sudokuArray[81]);
            sudokuCollection.add(Integer.parseInt(tmp.getGameID()), tmp);

        }

        In.close();
    }

    public void clearField() {

        model.clear();
    }

    public void resetGameChoose() {

        resetValues();
        gameChosen = false;
    }

    public boolean isReadOnly(int i, int j) {

        if (sudoku.getSudokuField()[i][j].equals("")) {

            return false;

        }

        return true;
    }

    public void getHint() {
        resetValues();
        model.hint();
    }

    public void resetValues() {

        model.setFieldIsEmpty(false);
        model.setFieldIsFilled(true);
        model.setSolvableHint(true);
        model.setSolvable(true);
        model.setSolvableHint(true);
        isCorrect = null;

    }

    public String saveNewSudokuToFile() {

        saveSudokuFromFile();

        In.open(FILE_NAME);
        Out.open(FILE_NAME);

        String sudokuArray[] = new String[81];

        String sudoku = "";

        for (int x = 0; x < sudokuCollection.size(); x++) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    sudoku = sudoku + sudokuCollection.get(x).getSudokuField()[i][j] + ",";


                }
            }

            sudoku = sudoku + sudokuCollection.get(x).getGameID() + "," + sudokuCollection.get(x).getGameTitle();

            Out.println(sudoku);
            sudoku = "";
        }


        for (int i = 0; i < model.getBoardValue().length; i++) {
            for (int j = 0; j < model.getBoardValue()[i].length; j++) {

                sudoku = sudoku + model.getBoardValue()[i][j] + ",";
            }
        }


        String gameid = (Integer.parseInt(sudokuCollection.get(sudokuCollection.size() - 1).getGameID()) + 1) + "";

        if (gameid.length() == 1) {
            gameid = "00" + gameid;
        } else if (gameid.length() == 2) {
            gameid = "0" + gameid;
        }

        sudoku = sudoku + gameid;
        sudoku = sudoku + ",Game #" + gameid;

        Out.println(sudoku);

        Out.close();
        In.close();

        Out.println("--> sudoku Game #" + gameid + " saved");

        return "index";
    }
}
