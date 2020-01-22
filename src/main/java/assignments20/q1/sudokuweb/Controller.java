package assignments20.q1.sudokuweb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Controller {

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

    public void checkSudoku(Sudoku sudoku) {

        isCorrect = model.checkSudoku(sudoku);
    }

    public Sudoku solveSudoku(Sudoku sudoku){

        return model.solveSudoku(sudoku);
    }

}
