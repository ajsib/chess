package chess;

public interface Piece {

    public boolean isLegalMove(Position newPosition);

    public void moveTo(Position newPosition);

    public Position getPosition();

    public int getColor();

    public boolean isCaptured();

    public void setCaptured(boolean captured);

    public boolean isLegalMove(Position newPosition, boolean isCapturing);
}