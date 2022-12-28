package chess;

public abstract class Board {

    private Position[][] board;
    private Piece[] capturedPiecesPlayer1;
    private Piece[] capturedPiecesPlayer2;

    public Board() {
        capturedPiecesPlayer1 = new Piece[16];
        capturedPiecesPlayer2 = new Piece[16];
        board = new Position[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Position(i, j);
            }
        }
    }

    public void fillBoard() {
        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new pawnPiece(board[1][i], 0, this));
            board[6][i].setPiece(new pawnPiece(board[6][i], 1, this));
        }
        board[0][0].setPiece(new rookPiece(board[0][0], 0, this));
        board[0][7].setPiece(new rookPiece(board[0][7], 0, this));
        board[7][0].setPiece(new rookPiece(board[7][0], 1, this));
        board[7][7].setPiece(new rookPiece(board[7][7], 1, this));
        board[0][1].setPiece(new knightPiece(board[0][1], 0, this));
        board[0][6].setPiece(new knightPiece(board[0][6], 0, this));
        board[7][1].setPiece(new knightPiece(board[7][1], 1, this));
        board[7][6].setPiece(new knightPiece(board[7][6], 1, this));
        board[0][2].setPiece(new bishopPiece(board[0][2], 0, this));
        board[0][5].setPiece(new bishopPiece(board[0][5], 0, this));
        board[7][2].setPiece(new bishopPiece(board[7][2], 1, this));
        board[7][5].setPiece(new bishopPiece(board[7][5], 1, this));
        board[0][3].setPiece(new queenPiece(board[0][3], 0, this));
        board[7][3].setPiece(new queenPiece(board[7][3], 1, this));
        board[0][4].setPiece(new kingPiece(board[0][4], 0, this));
        board[7][4].setPiece(new kingPiece(board[7][4], 1, this));
    }

    public Piece getPiece(int row, int column) {
        return board[row][column].getPiece();
    }

    public Piece getPiece(Position position) {
        return board[position.getRow()][position.getColumn()].getPiece();
    }

    public Position getPosition(int row, int column) {
        return board[row][column];
    }

    public void setPiece(int row, int column, Piece piece) {
        board[row][column].setPiece(piece);
    }

    public void removePiece(int row, int column) {
        board[row][column].setPiece(null);
    }

    public void setCapturedSquare(Piece piece) {
        if (piece.getColor() == 0) {
            for (int i = 0; i < capturedPiecesPlayer1.length; i++) {
                if (capturedPiecesPlayer1[i] == null) {
                    capturedPiecesPlayer1[i] = piece;
                    break;
                }
            }
        } else {
            for (int i = 0; i < capturedPiecesPlayer2.length; i++) {
                if (capturedPiecesPlayer2[i] == null) {
                    capturedPiecesPlayer2[i] = piece;
                    break;
                }
            }
        }
    }

    public static boolean isDiagonal(Position position1, Position position2) {
        return Math.abs(position1.getRow() - position2.getRow()) == Math.abs(position1.getColumn() - position2.getColumn());
    }

    public static boolean diagonalIsClear(Position position1, Position position2, Board board) {
        int row1 = position1.getRow();
        int column1 = position1.getColumn();
        int row2 = position2.getRow();
        int column2 = position2.getColumn();
        int rowIncrement = (row2 - row1) / Math.abs(row2 - row1);
        int columnIncrement = (column2 - column1) / Math.abs(column2 - column1);
        for (int i = 1; i < Math.abs(row2 - row1) - 1; i++) {
            if (board.getPiece(row1 + i * rowIncrement, column1 + i * columnIncrement) != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAdjacent(Position position1, Position position2) {
        return Math.abs(position1.getRow() - position2.getRow()) <= 1 && Math.abs(position1.getColumn() - position2.getColumn()) <= 1;
    }

    public static boolean isStraight(Position position1, Position position2) {
        return position1.getRow() == position2.getRow() || position1.getColumn() == position2.getColumn();
    }

    public static boolean straightIsClear(Position position1, Position position2, Board board) {
        int row1 = position1.getRow();
        int column1 = position1.getColumn();
        int row2 = position2.getRow();
        int column2 = position2.getColumn();
        if (row1 == row2) {
            int columnIncrement = (column2 - column1) / Math.abs(column2 - column1);
            for (int i = 1; i < Math.abs(column2 - column1) - 1; i++) {
                if (board.getPiece(row1, column1 + i * columnIncrement) != null) {
                    return false;
                }
            }
        } else {
            int rowIncrement = (row2 - row1) / Math.abs(row2 - row1);
            for (int i = 1; i < Math.abs(row2 - row1) - 1; i++) {
                if (board.getPiece(row1 + i * rowIncrement, column1) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLShape(Position position1, Position position2) {
        return (Math.abs(position1.getRow() - position2.getRow()) == 2 &&
        Math.abs(position1.getColumn() - position2.getColumn()) == 1) ||
        (Math.abs(position1.getRow() - position2.getRow()) == 1 && 
        Math.abs(position1.getColumn() - position2.getColumn()) == 2);
    }

    public static boolean isClearUp(Position position1, Position position2, boolean firstMove, int player){
        int row1 = position1.getRow();
        int column1 = position1.getColumn();
        int row2 = position2.getRow();
        int column2 = position2.getColumn();
        int moveLength = row1 - row2;
        if(player == 1){
            if (firstMove && moveLength == 2 && column1 == column2){
                return true;
            }
            else if (!firstMove && moveLength == 1 && column1 == column2){
                return true;
            }
        }
        else if(player == 0){
            if (firstMove && moveLength == -2 && column1 == column2){
                return true;
            }
            else if (!firstMove && moveLength == -1 && column1 == column2){
                return true;
            }
        }
        return false;
    }

    public static boolean isDiagonalOneUp(Position position1, Position position2, int player){
        int row1 = position1.getRow();
        int column1 = position1.getColumn();
        int row2 = position2.getRow();
        int column2 = position2.getColumn();
        int moveLength = row1 - row2;
        if (player == 1 &&moveLength == 1 && Math.abs(column1 - column2) == 1){
            return true;
        }
        if (player == 0 && moveLength == -1 && Math.abs(column1 - column2) == 1){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String boardString = "";
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (board[i][j].getPiece() == null){
                    boardString += " 0 ";
                }
                else{
                    boardString += " " +  board[i][j].getPiece().toString() + " ";
                }
            }
            boardString += "\n";
        }
        return boardString;
    }
}