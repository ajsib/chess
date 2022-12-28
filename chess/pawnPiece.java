package chess;

public class pawnPiece extends Piece{

    public boolean isFirstMove = true;

    public pawnPiece(Position position, int color, Board board){
        super(position, color, board);
    }

    @Override
    public boolean isLegalMove(Position newPosition){
        if (((Board.isClearUp(this.getPosition(), newPosition, this.isFirstMove, super.color) && newPosition.isClear()) ||
        (!newPosition.isClear() && Board.isDiagonalOneUp(this.getPosition(), newPosition, super.color))) && !isCaptured()){
            return true;
        }
        return false;
    }

    @Override
    public void moveTo(int row, int column){
        Position newPosition = board.getPosition(row, column);
        if (isLegalMove(newPosition)){
            this.position.removePiece();
            this.setPosition(newPosition);
            newPosition.setPiece(this);
            if (this.isFirstMove){
                isFirstMove = false;
            }
        }
        else{
            System.err.println("Illegal move");
        }
    }

    @Override
    public String toString(){
        if (this.color == 0){
            return "\u2659";
        }
        return "\u265F";
    }
}