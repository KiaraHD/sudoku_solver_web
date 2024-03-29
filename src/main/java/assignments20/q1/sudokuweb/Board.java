package assignments20.q1.sudokuweb;

public class Board {
    private String boardValue[][];
    private String solvedField[][];
    private boolean solvable;
    private boolean fieldIsEmpty;
    private boolean fieldIsFilled;
    private boolean solvableHint;

    public Board() {

        boardValue = new String[9][9];
        solvedField = new String[9][9];
        fieldIsEmpty = false;
        fieldIsFilled = true;
        solvableHint = true;

        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                boardValue[i][j] = new String();
            }
        }

        for (int i = 0; i < solvedField.length; i++) {
            for (int j = 0; j < solvedField[i].length; j++) {

                solvedField[i][j] = new String();
            }
        }

    }


    public String[][] getSolvedField() {
        return solvedField;
    }

    public void setSolvedField(String[][] solvedField) {
        this.solvedField = solvedField;
    }

    public boolean isSolvableHint() {
        return solvableHint;
    }

    public void setSolvableHint(boolean solvableHint) {
        this.solvableHint = solvableHint;
    }

    public boolean isFieldIsFilled() {
        return fieldIsFilled;
    }

    public void setFieldIsFilled(boolean fieldIsFilled) {
        this.fieldIsFilled = fieldIsFilled;
    }

    public boolean isFieldIsEmpty() {
        return fieldIsEmpty;
    }

    public void setFieldIsEmpty(boolean fieldIsEmpty) {
        this.fieldIsEmpty = fieldIsEmpty;
    }

    public String[][] getBoardValue() {
        return boardValue;
    }

    public void setBoardValue(String[][] boardValue) {

        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                this.boardValue[i][j] = boardValue[i][j];
            }
        }
    }

    public void setSolvable(boolean solvable) {
        this.solvable = solvable;
    }

    public boolean checkSudoku() {

        fieldIsEmpty = IsEmpty();
        fieldIsFilled = fieldIsComplete();

        if (fieldIsEmpty || !fieldIsFilled) {

            return false;
        }

        for (int row = 0; row < 9; row++) {

            if (!isValidRow(readRow(row))) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {

            if (!isValidColumn(readColumn(col))) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {

                if (!isValidField(readField(row, col))) {
                    return false;
                }
            }
        }

        return true;
    }


    private String[] readRow(int numberOfRow) {

        String[] row = new String[9];

        for (int i = 0; i < 9; i++) {

            row[i] = boardValue[i][numberOfRow];
        }
        return row;
    }

    private String[] readColumn(int numberOfCol) {

        String[] column = new String[9];

        for (int i = 0; i < 9; i++) {

            column[i] = boardValue[numberOfCol][i];
        }
        return column;
    }

    private String[] readField(int numberOfRow, int numberOfCol) {
        String[] field = new String[9];

        int val = 0;

        numberOfRow = numberOfRow / 3 * 3;
        numberOfCol = numberOfCol / 3 * 3;

        for (int i = numberOfRow; i < numberOfRow + 3; i++) {
            for (int j = numberOfCol; j < numberOfCol + 3; j++) {

                field[val] = boardValue[j][i];
                val++;
            }
        }
        return field;
    }

    private boolean isValidColumn(String column[]) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0;

        for (int i = 0; i < 9; i++) {
            switch (column[i]) {
                case "1":
                    count1++;
                    break;
                case "2":
                    count2++;
                    break;
                case "3":
                    count3++;
                    break;
                case "4":
                    count4++;
                    break;
                case "5":
                    count5++;
                    break;
                case "6":
                    count6++;
                    break;
                case "7":
                    count7++;
                    break;
                case "8":
                    count8++;
                    break;
                case "9":
                    count9++;
                    break;
                case "":
                    break;
                default:
                    return false;
            }

            if (count1 > 1 || count2 > 1 || count3 > 1 || count4 > 1 || count5 > 1 || count6 > 1 || count7 > 1 || count8 > 1 || count9 > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(String row[]) {

        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0;
        for (int i = 0; i < 9; i++) {

            switch (row[i]) {
                case "1":
                    count1++;
                    break;
                case "2":
                    count2++;
                    break;
                case "3":
                    count3++;
                    break;
                case "4":
                    count4++;
                    break;
                case "5":
                    count5++;
                    break;
                case "6":
                    count6++;
                    break;
                case "7":
                    count7++;
                    break;
                case "8":
                    count8++;
                    break;
                case "9":
                    count9++;
                    break;
                case "":
                    break;

                default:
                    return false;
            }
            if (count1 > 1 || count2 > 1 || count3 > 1 || count4 > 1 || count5 > 1 || count6 > 1 || count7 > 1 || count8 > 1 || count9 > 1) {

                return false;
            }
        }
        return true;
    }

    private boolean isValidField(String[] field) {

        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0;
        for (int i = 0; i < 9; i++) {

            switch (field[i]) {
                case "1":
                    count1++;
                    break;
                case "2":
                    count2++;
                    break;
                case "3":
                    count3++;
                    break;
                case "4":
                    count4++;
                    break;
                case "5":
                    count5++;
                    break;
                case "6":
                    count6++;
                    break;
                case "7":
                    count7++;
                    break;
                case "8":
                    count8++;
                    break;
                case "9":
                    count9++;
                    break;
                case "":
                    break;
                default:
                    return false;
            }
        }

        if (count1 > 1 || count2 > 1 || count3 > 1 || count4 > 1 || count5 > 1 || count6 > 1 || count7 > 1 || count8 > 1 || count9 > 1) {

            return false;
        }
        return true;
    }

    public boolean containedInRow(int row, int number) {

        for (int i = 0; i < 9; i++) {

            if (solvedField[row][i].equals(Integer.toString(number))) {

                return true;
            }
        }
        return false;
    }

    public boolean containedInColumn(int col, int number) {

        for (int i = 0; i < 9; i++) {

            if (solvedField[i][col].equals(Integer.toString(number))) {

                return true;
            }
        }
        return false;
    }

    public boolean containedInField(int row, int col, int number) {
        row = row / 3 * 3;
        col = col / 3 * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {

                if (solvedField[i][j].equals(Integer.toString(number))) {

                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(int row, int col, int number) {
        if (containedInRow(row, number) || containedInColumn(col, number) || containedInField(row, col, number)) {
            return false;
        } else {
            return true;
        }
    }


    public boolean solveSudoku() {


        if (!boardIsValid()) {
            return false;
        }


        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                solvedField[i][j] = boardValue[i][j];
            }
        }

        fieldIsEmpty = IsEmpty();

        if (fieldIsEmpty) {
            return false;
        }

        solvable = solve();

        boardValue = solvedField;

        return solvable;
    }


    public void clear() {

        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                boardValue[i][j] = "";
            }
        }
    }

    public boolean IsEmpty() {

        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                if (!boardValue[i][j].equals("")) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean fieldIsComplete() {

        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                if (boardValue[i][j].equals("")) {

                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected Object clone() {

        Board clone = new Board();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                clone.getBoardValue()[i][j] = boardValue[i][j];
            }
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {

        Board other = (Board) obj;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (!(boardValue[i][j].equals(other.getBoardValue()[i][j]))) {

                    return false;
                }
            }
        }
        return true;
    }


    public boolean solve() {


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (solvedField[i][j].equals("")) {

                    for (int number = 1; number <= 9; number++) {

                        if (isValid(i, j, number)) {

                            solvedField[i][j] = Integer.toString(number);

                            if (solve()) {
                                return true;
                            } else {

                                solvedField[i][j] = ("");
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean hint() {


        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                solvedField[i][j] = boardValue[i][j];
            }
        }


        solvableHint = boardIsValid();

        if (!solvableHint) {
            return false;
        }


        solvableHint = solve();

        int indexI = 0;
        int indexJ = 0;
        boolean firstEmpty = true;
        for (int i = 0; i < boardValue.length; i++) {
            for (int j = 0; j < boardValue[i].length; j++) {

                if (boardValue[i][j].equals("") && firstEmpty == true) {
                    indexI = i;
                    indexJ = j;
                    firstEmpty = false;
                }
            }
        }

        if (firstEmpty == false) {

            boardValue[indexI][indexJ] = solvedField[indexI][indexJ];

            return true;
        }

        return false;
    }

    public boolean boardIsValid() {

        for (int row = 0; row < 9; row++) {

            if (!isValidRow(readRow(row))) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {

            if (!isValidColumn(readColumn(col))) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {

                if (!isValidField(readField(row, col))) {
                    return false;
                }
            }
        }

        return true;
    }
}