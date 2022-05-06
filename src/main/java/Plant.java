public abstract class Plant implements BoardMovement{

    int roundToReproduce;
    int rounds;
    int reproduceChance;

    public Plant(int toReproduce, int reproduceChance){
        this.reproduceChance = toReproduce;
        this.rounds = 0;
        this.reproduceChance = reproduceChance;
    }
    public abstract Plant reproduce();
}
