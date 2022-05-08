public abstract class Plant implements BoardMovement{

    int roundToReproduce;
    int rounds;
    double reproduceChance;

    public Plant(int toReproduce, int reproduceChance){
        this.roundToReproduce = toReproduce;
        this.rounds = 0;
        this.reproduceChance = (double) reproduceChance / 100;
    }

    public Plant(int toReproduce, double reproduceChance){
        this.roundToReproduce = toReproduce;
        this.rounds = 0;
        this.reproduceChance = reproduceChance;
    }

    @Override
    public BoardMovement makeInteraction(BoardMovement with){
        return null;
    }

    public abstract Plant reproduce();
}
