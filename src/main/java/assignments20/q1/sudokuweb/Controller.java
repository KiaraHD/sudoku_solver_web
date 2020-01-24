package assignments20.q1.sudokuweb;

import libs.inout.In;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@RequestScoped
public class Controller {

    private Sudoku sudokuTemplate;
    private List<Sudoku> sudokuCollection = new ArrayList();
    private String gameid;
    private Model model = new Board();
    private Boolean isCorrect;
    private String keyboard = "123,456,789";

    final static String FILE_NAME = "/home/kiara/work/itl/src/main/java/assignments20/q1/sudokuweb/SudokuGames";

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

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

    public List<Sudoku> getSudokus() {
        return sudokuCollection;
    }

    public void setSudokus(ArrayList<Sudoku> sudokus) {
        this.sudokuCollection = sudokus;
    }


    public void checkSudoku() {

        isCorrect = model.checkSudoku();
    }

    public void solveSudoku() {

        isCorrect = model.solveSudoku();
    }

    public List generateList() {

        sudokuCollection.clear();

        saveSudokuFromFile();

        return sudokuCollection;
    }

    public Sudoku setSudoku(Sudoku sudoku, String gameID) {

        Sudoku tmp;

        if (gameID.equals("")) {

            Random rand = new Random();
            int randomNum = rand.nextInt(sudokuCollection.size() + 1);

            tmp = sudokuCollection.get(randomNum);

        } else {

            tmp = sudokuCollection.get(Integer.parseInt(gameID));
        }

        sudoku.setSudokuField(tmp.getSudokuField());
        return sudoku;
    }

    public void saveSudokuFromFile() {

        //what the txd file should look like: 5,3,4,,7,8,,1,2,,7,2,1,9,5,3,4,,1,9,8,,4,,5,,7,8,,9,,6,1,4,,3,,2,6,,5,3,7,9,1,7,,3,9,2,,8,,6,9,6,1,,3,,2,8,4,,8,7,4,,9,6,,5,3,4,5,,8,,1,7,9,001,Game #000
        //81 Zeichen field (durch komma gestrennt) -> 3 Zeichen ID  -> restliche Zeichen Name (9 Zeichen)

        In.open(FILE_NAME);

        while (!In.done()) {
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
            sudokuCollection.add(tmp);

        }

        In.close();
    }

    public void clearField(){

        model.clear();
    }

}