public interface BoardMovement {

    String getEmoji();

    BoardMovement makeInteraction(BoardMovement with);

    BoardMovement makeMovementAction();

    boolean didDeceased();

    boolean canMove();
}
