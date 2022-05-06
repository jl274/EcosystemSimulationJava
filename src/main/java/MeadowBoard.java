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


    public void printBoard(){
        for (int iX = 0; iX < xSize; iX++){
            for (int iY = 0; iY < ySize; iY++){

                if (this.isFieldEmpty(iX, iY)){
                    System.out.print(this.meadowEmoji);
                } else {
                    // not implemented yet
                }

            }
            System.out.println("");
        }
    }
}
