import lombok.Getter;

public abstract class Plant implements BoardMovement{

    int roundToReproduce;
    int rounds;
    double reproduceChance;
    private boolean deceased;

    public Plant(int toReproduce, int reproduceChance){
        this.roundToReproduce = toReproduce;
        this.rounds = 0;
        this.reproduceChance = (double) reproduceChance / 100;
        this.deceased = false;
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

    @Override
    public BoardMovement makeMovementAction() {
        this.rounds++;
        double randomNumber = Math.random();
        if (this.rounds >= this.roundToReproduce){
            this.rounds = 0;
            return this.reproduce();
        } else if (randomNumber < this.reproduceChance){
            this.rounds = 0;
            return this.reproduce();
        }
        return null;
    }

    @Override
    public boolean didDeceased() {
        return this.deceased;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    public void beingEaten(){
        this.deceased = true;
    }

    public abstract Plant reproduce();
}
