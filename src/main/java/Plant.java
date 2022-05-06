public abstract class Plant implements BoardMovement{

    int roundToReproduce;
    int rounds;
    float reproduceChance;

    public Plant(int toReproduce, int reproduceChance){
        this.roundToReproduce = toReproduce;
        this.rounds = 0;
        this.reproduceChance = (float) reproduceChance / 100;
    }

    public Plant(int toReproduce, float reproduceChance){
        this.roundToReproduce = toReproduce;
        this.rounds = 0;
        this.reproduceChance = reproduceChance;
    }
    public abstract Plant reproduce();
}
