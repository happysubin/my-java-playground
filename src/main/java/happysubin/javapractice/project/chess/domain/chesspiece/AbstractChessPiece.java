package happysubin.javapractice.project.chess.domain.chesspiece;


import happysubin.javapractice.project.chess.domain.Position;

public abstract class AbstractChessPiece implements ChessPiece{
    
    private Color color;
    private Position position;

    public AbstractChessPiece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public boolean isEnemy(ChessPiece chessPiece) {
        if(isSameTeam(chessPiece)) return false;
        return true;
    }

    private boolean isSameTeam(ChessPiece chessPiece) {
        return chessPiece.getColor() == this.color;
    }
}
