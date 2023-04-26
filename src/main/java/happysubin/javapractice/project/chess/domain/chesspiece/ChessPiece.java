package happysubin.javapractice.project.chess.domain.chesspiece;

public interface ChessPiece {
    void move();
    boolean isEnemy(ChessPiece chessPiece);

    Color getColor();

}
