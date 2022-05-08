public interface BoardMovement {

    String getEmoji();

    BoardMovement makeInteraction(BoardMovement with);

    boolean didDeceased();
}
