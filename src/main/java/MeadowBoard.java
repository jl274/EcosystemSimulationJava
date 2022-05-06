import lombok.Getter;

public class MeadowBoard {

    @Getter private BoardMovement[][] meadow;
    private final String meadowEmoji;
    @Getter private final int xSize;
    @Getter private final int ySize;

    public MeadowBoard(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        this.meadow = new BoardMovement[xSize][ySize];
        this.meadowEmoji = "\uD83D\uDFE9";
    }

    public boolean isFieldEmpty(int x, int y){
        return this.meadow[x][y] == null;
    }

}
