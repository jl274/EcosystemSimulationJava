import lombok.Getter;

public class Grass extends Plant {

    @Getter private final String Emoji;

    public Grass(){
        super(4, 0.2);
        this.Emoji = "\uD83C\uDF3F";
    }

    @Override
    public Plant reproduce() {
        return new Grass();
    }

}
