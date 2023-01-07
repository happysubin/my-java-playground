package happysubin.javapractice.project.bridge.src.domain.move;

@FunctionalInterface
public interface MoveStrategy {
    String getMoveCommand();
}
