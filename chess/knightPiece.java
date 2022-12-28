package chess;

public class knightPiece extends Piece{

    knightPiece(Position position, int color, Board board){
        super(position, color, board);
    }

    @Override
    public boolean isLegalMove(Position newPosition){
        if (Board.isLShape(this.getPosition(), newPosition) && !isCaptured()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        if (this.color == 0){
            return "\u2658";
        }
        return "\u265E";
    }
}