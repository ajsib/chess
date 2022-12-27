package chess;

public class bishopPiece implements Piece{

    private Position position;
    private int color;
    private boolean captured;
    private Board board;

    public bishopPiece(Position position, int color, Board board){
        this.position = position;
        this.color = color;
        this.captured = false;
        this.board = board;
    }

    @Override
    public boolean isLegalMove(Position newPosition){
        if (Position.isDiagonal(this.getPosition(), newPosition) && board.getPiece(newPosition) == null && !isCaptured()){
            return true;
        }
    }

    @Override
    public void moveTo(Position newPosition){
        if (isLegalMove(newPosition)){
            this.setPosition(newPosition);
        }
    }

    @Override
    public Position getPosition(){

    }

    @Override
    public int getColor(){

    }

    @Override
    public boolean isCaptured(){

    }

    @Override
    public void setCaptured(boolean captured){

    }

    @Override
    public boolean isLegalMove(Position newPosition, boolean isCapturing){

    }

    @Override
    public void setPosition(Position newPosition){

    }

}