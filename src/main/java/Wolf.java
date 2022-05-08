import lombok.Getter;

public class Wolf extends Carnivorous{

    @Getter private final String Emoji;

    public Wolf(){
        super(2, 5, 6);
        this.Emoji = "\uD83D\uDC3A";
    }

    @Override
    public Animal reproduce() {
        this.timesAteToReproduce *= this.timesAteToReproduce;
        return new Wolf();
    }

    @Override
    public boolean eatAnimal(Animal animal) {
        if (this.health > animal.health){
            this.roundsStarving = 0;
            this.ate++;
            if (this.ate == this.timesAteToReproduce){
                this.ate = 0;
                return true;
            }
        }
        return false;
    }
}
