public abstract class Plant implements BoardMovement{

    int roundToReproduce;
    int rounds;
    int reproduceChange;

    public abstract Plant reproduce();
}
