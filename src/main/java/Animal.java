public abstract class Animal implements BoardMovement {

    int timesAteToReproduce;
    int ate;
    int endurance;
    int health;

    public abstract Animal reproduce();
    public abstract boolean Eat(BoardMovement sth);
}
