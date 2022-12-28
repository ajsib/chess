package chess;

public abstract class Piece {

    protected Position position;
    protected int color;
    protected boolean captured;
    protected Board board;

    public Piece(Position position, int color, Board board){
        this.position = position;
        this.color = color;
        this.captured = false;
        this.board = board;
    }

    public Position getPosition(){
        return this.position;
    }

    public int getColor(){
        return this.color;
    }

    public boolean isCaptured(){
        return this.captured;
    }

    public void setCaptured(boolean captured){
        this.captured = captured;
    }

    public void moveTo(Position newPosition){
        if (isLegalMove(newPosition)){
            this.setPosition(newPosition);
        }
        else{
            System.err.println("Illegal move");
        }
    }

    public abstract boolean isLegalMove(Position newPosition);

    public void setPosition(Position newPosition){
        if (newPosition.getPiece() != null){
            newPosition.getPiece().setCaptured(true);
            board.setCapturedSquare(newPosition.getPiece());
        }
        this.position = newPosition;
    }
}