public abstract class Animal implements BoardMovement {

    int timesAteToReproduce;
    int ate;
    int endurance;
    int health;
    int roundsStarving;

    public Animal(int toReproduce, int endurance, int health){
        this.timesAteToReproduce = toReproduce;
        this.ate = 0;
        this.endurance = endurance;
        this.health = health;
        this.roundsStarving = 0;
    }

    public abstract Animal reproduce();
    public abstract boolean eat(BoardMovement sth);
}
