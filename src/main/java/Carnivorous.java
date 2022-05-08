public abstract class Carnivorous extends Animal {

    public Carnivorous(int toReproduce, int endurance, int health){
        super(toReproduce, endurance, health);
    }

    public abstract boolean eatAnimal(Animal animal);

    @Override
    public boolean eat(BoardMovement sth) {
        if (sth instanceof Animal){
            return this.eatAnimal((Animal) sth);
        } else {
            throw new IllegalArgumentException("Carnivorous animals can only eat other animals");
        }
    }

    @Override
    public boolean canEat(BoardMovement sth) {
        return sth instanceof Herbivorous;
    }
}
