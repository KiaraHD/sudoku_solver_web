package assignments20.q1.sudokuweb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Controller {

    Model model = new Board();

    private String keyboard = "123,456,789";

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void checkSudoku(Sudoku sudoku) {

        model.checkSudoku(sudoku);
    }
}
