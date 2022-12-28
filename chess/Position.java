package chess;

public class Position {
    private int row;
    private int column;
    private Piece piece;
    private int color;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
        this.color = (row + column) % 2;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }

    public int getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isClear() {
        return piece == null;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Position)) {
            return false;
        }
        Position otherPosition = (Position) other;
        return otherPosition.getRow() == row && otherPosition.getColumn() == column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}