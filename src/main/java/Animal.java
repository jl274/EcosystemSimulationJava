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

    @Override
    public boolean didDeceased() {
        return this.health <= 0;
    }

    @Override
    public BoardMovement makeInteraction(BoardMovement with){
        if (this.canEat(with)){
            boolean willReproduce = this.eat(with);
            if (willReproduce){
                return this.reproduce();
            }
        }
        return null;
    }

    @Override
    public BoardMovement makeMovementAction() {
        return null;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    public boolean canEat(BoardMovement sth){
        return false;
    }

    public abstract Animal reproduce();
    public abstract boolean eat(BoardMovement sth);
}
