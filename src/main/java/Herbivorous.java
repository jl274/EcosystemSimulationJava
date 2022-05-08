public abstract class Herbivorous extends Animal {

    public Herbivorous(int toReproduce, int endurance, int health){
        super(toReproduce, endurance, health);
    }

    public abstract boolean eatPlant(Plant plant);

    @Override
    public boolean eat(BoardMovement sth) {
        if (sth instanceof Plant){
            return this.eatPlant((Plant) sth);
        } else {
            throw new IllegalArgumentException("Herbivorous animals can only eat plants");
        }
    }

    @Override
    public boolean canEat(BoardMovement sth) {
        return sth instanceof Plant;
    }
}
