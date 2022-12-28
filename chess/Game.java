package chess;

public class Game extends Board {

    Game(){
        super();
    }

    public static void main(String[] args) {
        Board board = new Game();
        board.fillBoard();


        Piece blackPawn1 = board.getPiece(1, 0);
        Piece blackPawn2 = board.getPiece(1, 1);
        Piece blackPawn3 = board.getPiece(1, 2);
        Piece blackPawn4 = board.getPiece(1, 3);
        Piece blackhorse1 = board.getPiece(0, 1);

        blackhorse1.moveTo(2, 2);
        blackhorse1.moveTo(4, 3);

        
        blackPawn1.moveTo(3, 0);
        blackPawn2.moveTo(3, 1);
        blackPawn3.moveTo(2, 2);
        blackPawn4.moveTo(2, 3);

        Piece whitePawn3 = board.getPiece(6, 0);

        whitePawn3.moveTo(3, 0);



        System.out.println(board.toString());
    }
}
