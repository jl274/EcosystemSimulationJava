import lombok.Getter;

public class Sheep extends Herbivorous{

    @Getter private final String Emoji;

    public Sheep(){
        super(6, 2, 2);
        this.Emoji = "\uD83D\uDC11";
    }

    private Sheep(int health){
        super(6, 2, health);
        this.Emoji = "\uD83D\uDC11";
    }

    @Override
    public Animal reproduce() {
        return new Sheep(this.health + 1);
    }

    @Override
    public boolean eatPlant(Plant plant) {
        plant.beingEaten();
        this.roundsStarving = 0;
        this.ate++;
        if (this.ate == this.timesAteToReproduce){
            this.ate = 0;
            return true;
        }
        return false;
    }
}
