package chess;

public class queenPiece extends Piece{

    public queenPiece(Position position, int color, Board board){
        super(position, color, board);
    }

    @Override
    public boolean isLegalMove(Position newPosition){
        if ((Board.isDiagonal(this.getPosition(), newPosition) && 
            Board.diagonalIsClear(this.position, newPosition, board)) || 
            (Board.isStraight(this.getPosition(), newPosition) && 
            Board.straightIsClear(this.position, newPosition, board)) && !isCaptured()){
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