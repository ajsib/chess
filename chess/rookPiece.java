package chess;

public class rookPiece extends Piece {

    public rookPiece(Position position, int color, Board board) {
        super(position, color, board);
    }

    @Override
    public boolean isLegalMove(Position newPosition) {
        if (Board.isStraight(this.getPosition(), newPosition) && Board.straightIsClear(this.position, newPosition, board) && !isCaptured()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.color == 0) {
            return "\u2656";
        }
        return "\u265C";
    }    
}
