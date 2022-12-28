package chess;

public class bishopPiece extends Piece{

    public bishopPiece(Position position, int color, Board board){
        super(position, color, board);
    }

    @Override
    public boolean isLegalMove(Position newPosition){
        if (Board.isDiagonal(this.getPosition(), newPosition) && 
            Board.diagonalIsClear(this.position, newPosition, board) && !isCaptured()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        if (this.color == 0){
            return "\u2657";
        }
        return "\u265D";
    }

}