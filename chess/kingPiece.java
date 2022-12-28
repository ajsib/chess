package chess;

public class kingPiece extends Piece{

    public kingPiece(Position position, int color, Board board){
        super(position, color, board);
    }

    @Override
    public boolean isLegalMove(Position newPosition){
        if (Board.isAdjacent(this.getPosition(), newPosition) && !isCaptured()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        if (this.color == 0){
            return "\u2654";
        }
        return "\u265A";
    }
}