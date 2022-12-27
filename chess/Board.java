package chess;

public class Board {

    private Position[][] board;

    public Board() {
        board = new Position[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Position(i, j);
            }
        }
    }

    public Piece getPiece(int row, int column) {
        return board[row][column].getPiece();
    }

    public Piece getPiece(Position position) {
        return board[position.getRow()][position.getColumn()].getPiece();
    }

    public void setPiece(int row, int column, Piece piece) {
        board[row][column].setPiece(piece);
    }

    public void removePiece(int row, int column) {
        board[row][column].setPiece(null);
    }    
}