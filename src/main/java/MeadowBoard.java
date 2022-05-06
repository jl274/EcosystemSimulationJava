import lombok.Getter;

public class MeadowBoard {

    @Getter private BoardMovement[][] meadow;

    public MeadowBoard(int xSize, int ySize){
        this.meadow = new BoardMovement[xSize][ySize];
    }

    public boolean isFieldEmpty(int x, int y){
        return this.meadow[x][y] == null;
    }
}
