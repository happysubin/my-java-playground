package happysubin.javapractice.project.bridge.src.domain.strategy.command;

@FunctionalInterface
public interface MoveCommandStrategy {
    String getMoveCommand();
}
