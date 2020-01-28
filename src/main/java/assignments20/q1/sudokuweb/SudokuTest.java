package assignments20.q1.sudokuweb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuTest {

    Board unsolved = new Board();
    Board unsolvedNotSolvable = new Board();
    Board solved = new Board();


    @Before
    public void setup() {


        String[][] unsolvedField = new String[][]{
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

        unsolved.setBoardValue(unsolvedField);

        String[][] unsolvedNotSolvableField = new String[][]{
                {"5", "3", "6", "", "5", "8", "", "1", "2"},
                {"", "7", "2", "1", "9", "5", "3", "4", ""},
                {"1", "9", "8", "", "5", "", "5", "", "7"},
                {"8", "", "9", "", "6", "1", "4", "", "3"},
                {"", "2", "6", "", "5", "3", "7", "9", "1"},
                {"7", "", "3", "9", "2", "", "8", "", "6"},
                {"9", "6", "1", "", "3", "", "2", "8", "4"},
                {"", "8", "7", "4", "", "9", "6", "", "5"},
                {"3", "4", "5", "", "8", "", "1", "7", "9"}
        };

        unsolvedNotSolvable.setBoardValue(unsolvedNotSolvableField);

        String[][] solvedField = new String[][]{
                {"5", "3", "4", "6", "7", "8", "9", "1", "2"},
                {"6", "7", "2", "1", "9", "5", "3", "4", "8"},
                {"1", "9", "8", "3", "4", "2", "5", "6", "7"},
                {"8", "5", "9", "7", "6", "1", "4", "2", "3"},
                {"4", "2", "6", "8", "5", "3", "7", "9", "1"},
                {"7", "1", "3", "9", "2", "4", "8", "5", "6"},
                {"9", "6", "1", "5", "3", "7", "2", "8", "4"},
                {"2", "8", "7", "4", "1", "9", "6", "3", "5"},
                {"3", "4", "5", "2", "8", "6", "1", "7", "9"}
        };
        solved.setBoardValue(solvedField);

    }

    @Test
    public void solveEqualsTrue() {

        unsolved.solve();

        assertTrue(unsolved.equals(solved));
    }

    @Test
    public void solveTestTrue() {

        assertTrue(unsolved.solve());
    }

    @Test
    public void solveEqualsFalse() {

        assertFalse(unsolvedNotSolvable.equals(solved));
    }

    @Test
    public void solveTestFalse() {

        assertFalse(unsolvedNotSolvable.solve());
    }

    @Test
    public void testEquals() {

        Board clone = (Board) solved.clone();

        assertFalse(solved == clone);
        assertTrue(solved.equals(clone));
    }

    @Test
    public void testContainedRowTrue() {

        assertTrue(unsolved.containedInRow(2, 8));
    }

    @Test
    public void testContainedRowFalse() {

        assertFalse(unsolved.containedInRow(2, 3));
    }

    @Test
    public void testContainedColumnTrue() {

        assertTrue(unsolved.containedInColumn(3, 1));
    }

    @Test
    public void testContainedColumnFalse() {

        assertFalse(unsolved.containedInColumn(3, 3));
    }

    @Test
    public void testContainedFieldTrue() {

        assertTrue(unsolved.containedInField(0, 0, 7));
    }

    @Test
    public void testContainedFieldFalse() {

        assertFalse(unsolved.containedInField(0, 0, 6));
    }

    @Test
    public void testValidTrue() {

        assertTrue(unsolved.isValid(1, 0, 6));
    }

    @Test
    public void testValidFalse() {

        assertFalse(unsolved.isValid(0, 2, 3));
    }

    @Test
    public void readField() {

        Controller controller = new Controller();
        controller.saveSudokuFromFile();
        solved.setBoardValue(controller.getSudokuCollection().get(0).getSudokuField());

        assertTrue(solved.equals(unsolved));

    }
}

